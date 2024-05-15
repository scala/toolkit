import Dependencies.*
import ChangelogException.*
import upickle.default.*
import scala.concurrent.duration.Duration

class ChangelogCheckerTest extends munit.FunSuite:
    val baseDeps = List(
        "com.softwaremill.sttp.client4::core::4.0.0-M14",
        "com.softwaremill.sttp.client4::upickle::4.0.0-M14",
        "org.scalameta::munit::1.0.0-RC1",
    )

    override val munitTimeout = Duration(90, "s")
    test("Pass if no changes occurred"):
        val change = LibraryChange("example", Version(1,0,0), Version(1,0,1), baseDeps, baseDeps)
        val result = runChangelog(change, Platform.Jvm)
        assert(result.isEmpty)
    
    test("Fail if changes occurred when no overwrite set"):
        val change = LibraryChange(
            "example",
            Version(1,0,0),
            Version(2,0,0),
            baseDeps,
            baseDeps :+ "com.lihaoyi::upickle::3.3.0"
        )
        intercept[AlreadyExists](runChangelog(change, Platform.Native))

    test("Generate a changelog"):
        val change = LibraryChange(
            "example",
            Version(1,0,0),
            Version(1,1,0), 
            baseDeps :+ "com.lihaoyi::upickle::3.0.0",
            baseDeps :+ "com.lihaoyi::upickle::3.3.0"
        )
        val changelog = runChangelog(change, Platform.Js, overwrite = true).get
        val updatedDep = changelog.directChanges.collectFirst {
            case change @ DepUpdated(Dep(s"com.lihaoyi:upickle$_", Version(3,0,0,_), _), Dep(s"com.lihaoyi:upickle$_", Version(3,3,0,_), _), _) => change
        }
        assert(updatedDep.nonEmpty)

    test("Disallow adding new library in patch update"):
        val change = LibraryChange("example", Version(1,0,0), Version(1,0,1),  baseDeps, (baseDeps :+ "com.lihaoyi::upickle::3.1.0"))
        intercept[IllegalDiffs](runChangelog(change, Platform.Js))
    
    test("Allow adding new library in minor update"):
        val change = LibraryChange("example", Version(1,0,0), Version(1,1,0), baseDeps, (baseDeps :+ "com.lihaoyi::upickle::3.1.0"))
        val changelog = runChangelog(change, Platform.Js, overwrite = true).get
        val addedDep = changelog.directChanges.collectFirst {
            case change @ Added(Dep(s"com.lihaoyi:upickle$_", Version(3,1,0,_), _), _) => change
        }
        assert(addedDep.nonEmpty)
    
    test("Disallow removing library in minor update"):
        val change = LibraryChange(
            "example", 
            Version(1,0,0),
            Version(1,1,0), 
            baseDeps :+ "com.lihaoyi::upickle::3.0.0",
            baseDeps
        )
        intercept[IllegalDiffs](runChangelog(change, Platform.Jvm))
    
    test("Allow removing library in major update"):
        val change = LibraryChange(
            "example", 
            Version(1,0,0),
            Version(2,0,0), 
            baseDeps :+ "com.lihaoyi::upickle::3.0.0",
            baseDeps
        )
        val changelog = runChangelog(change, Platform.Jvm, overwrite = true).get
        val removedDep = changelog.directChanges.collectFirst {
            case change @ Removed(Dep(s"com.lihaoyi:upickle$_", Version(3,0,0,_), _), _) => change
        }

    test("Disallow direct major dep change in minor update"):
        val change = LibraryChange(
            "example", 
            Version(1,0,0),
            Version(1,1,0), 
            baseDeps :+ "com.lihaoyi::upickle::2.0.0",
            baseDeps :+ "com.lihaoyi::upickle::3.0.0"
        )
        intercept[IllegalDiffs](runChangelog(change, Platform.Jvm))

    test("Disallow minor dep change in patch update"):
        val change = LibraryChange(
            "example", 
            Version(1,0,0),
            Version(1,0,1), 
            baseDeps :+ "com.lihaoyi::upickle::3.0.0",
            baseDeps :+ "com.lihaoyi::upickle::3.1.0"
        )
        intercept[IllegalDiffs](runChangelog(change, Platform.Js))
    
    test("Disallow transitive major dep change in minor update"):
        val change = LibraryChange(
            "example", 
            Version(1,0,0), Version(1,1,0), 
            baseDeps :+ "com.lihaoyi::os-lib::0.8.1",
            baseDeps :+ "com.lihaoyi::os-lib::0.9.0"
        )
        intercept[IllegalDiffs](runChangelog(change, Platform.Jvm))
    
    test("Allow major milestone change in major milestone update"):
        val change = LibraryChange(
            "example", 
            Version(1,0,0,Some("M2")), Version(1,0,0,Some("M3")), 
            baseDeps :+ "com.lihaoyi::upickle::3.0.0-M1",
            baseDeps :+ "com.lihaoyi::upickle::3.0.0-M2"
        )
        runChangelog(change, Platform.Js, overwrite = true)
    
    test("Disallow major milestone change in minor milestone update"):
        val change = LibraryChange(
            "example", 
            Version(1,1,0,Some("M2")), 
            Version(1,1,0,Some("M3")), 
            baseDeps :+ "com.lihaoyi::upickle::3.0.0-M1",
            baseDeps :+ "com.lihaoyi::upickle::3.0.0-M2"
        )
        intercept[IllegalDiffs](runChangelog(change, Platform.Js, overwrite = true))
    
    test("Disallow rollback of minor version in minor update"):
        val change = LibraryChange(
            "example", 
            Version(1,0,0),
            Version(1,1,0), 
            baseDeps :+ "com.lihaoyi::upickle::3.1.0",
            baseDeps :+ "com.lihaoyi::upickle::3.0.0"
        )
        intercept[IllegalDiffs](runChangelog(change, Platform.Jvm, overwrite = true))
    
    test("Allow rollback of minor version in major update"):
        val change = LibraryChange(
            "example", 
            Version(1,0,0),
            Version(2,0,0), 
            baseDeps :+ "com.lihaoyi::upickle::3.3.0",
            baseDeps :+ "com.lihaoyi::upickle::3.0.0"
        )
        runChangelog(change, Platform.Js, overwrite = true)

    case class LibraryChange(
        moduleName: String,
        releaseVersion: Version,
        developmentVersion: Version,
        releaseDeps: List[String],
        developmentDeps: List[String]
    )

    private def runChangelog(change: LibraryChange, platform: Platform, overwrite: Boolean = false): Option[Changelog] = 
        publish(change.moduleName, change.releaseVersion.toString, change.releaseDeps, platform)
        val fileWithChanges = generateConfigFile(change.moduleName, change.developmentVersion.toString, change.developmentDeps)
        val outputDir = os.temp.dir()
        val config = Config("com.example", outputDir, change.releaseVersion, change.developmentVersion)
        val changelogChecker = ChangelogChecker(config, Seq.empty, overwrite, yes = true)
        changelogChecker.check(fileWithChanges, change.moduleName, platform)
        os.list(outputDir)
            .flatMap(path => os.list(path / "json"))
            .headOption
            .map(file => read[Changelog](os.read(file)))

    private def generateConfigFile(moduleName: String, version: String, deps: List[String]): os.Path = 
        // scala-cli config file write
        os.temp(
            s"""|//> using scala 2.13, 3.3
                |//> using publish.name $moduleName
                |${deps.map(d => s"//> using dep $d").mkString("\n")}
                |//> using publish.version $version
                |//> using publish.organization com.example
                | """.stripMargin,
            suffix = ".scala"
        )

    private def publish(id: String, version: String, deps: List[String], platform: Platform) = 
        val file = generateConfigFile(id, version, deps)
        os.proc("scala-cli", "--power", "publish", "local", platform.scalaCliOptions, "--cross", file)
            .call(stderr = os.Pipe) // mute warnings
