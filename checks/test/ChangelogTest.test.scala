import Dependencies.*
import upickle.default.*
import ChangelogTest.*
import scala.concurrent.duration.Duration
import ox.*

class ChangelogTest extends munit.FunSuite:
    val baseDeps = List(
        "com.softwaremill.sttp.client4::core::4.0.0-M1",
        "com.softwaremill.sttp.client4::upickle::4.0.0-M1",
        "org.scalameta::munit::1.0.0-M8",
    )

    override val munitTimeout = Duration(60, "s")
    test("Pass if no changes occurred"):
        val change = LibraryChange("example", 
            Version(1,0,0) -> Version(1,0,1), 
            baseDeps -> baseDeps
        )
        val result = ChangelogTest.runChangelog(change)
        result match
            case ChangelogSuccess(out, changelogs) =>
                assert(changelogs.isEmpty)
            case ChangelogFailure(logs) =>
                fail("Changelog generation failed: " + logs)
    
    test("Fail if changes occurred when no overwrite set"):
        val change = LibraryChange("example", 
            Version(1,0,0) -> Version(2,0,0), 
            baseDeps -> (baseDeps :+ "com.lihaoyi::upickle::3.1.0")
        )
        val result = ChangelogTest.runChangelog(change)
        result match
            case ChangelogSuccess(out, changelogs) =>
                fail("Changelog generation should have failed")
            case ChangelogFailure(logs) =>
                assert(logs.contains("Please run with --overwrite to overwrite the expected changelog."))

    test("Generate a changelog"):
        val change = LibraryChange("example", 
            Version(1,0,0) -> Version(1,1,0), 
            (baseDeps :+ "com.lihaoyi::upickle::3.0.0") -> (baseDeps :+ "com.lihaoyi::upickle::3.1.0")
        )
        val result = ChangelogTest.runChangelog(change, overwrite = true)
        result match
            case ChangelogSuccess(out, changelogs) =>
                changelogs.foreach((_, changelog) => 
                    assert(changelog.directChanges.exists(c => c match
                        case DepUpdated(Dep(s"com.lihaoyi:upickle$_", Version(3,0,0,_), _), Dep(s"com.lihaoyi:upickle$_", Version(3,1,0,_), _), _) => true
                        case _ => false))
                )
            case ChangelogFailure(logs) =>
                fail("Changelog generation failed: " + logs)

    test("Disallow adding new library in patch update"):
        val change = LibraryChange("example", 
            Version(1,0,0) -> Version(1,0,1), 
            baseDeps -> (baseDeps :+ "com.lihaoyi::upickle::3.1.0")
        )
        val result = ChangelogTest.runChangelog(change, overwrite = true)
        result match
            case ChangelogSuccess(out, changelogs) =>
                fail("Changelog generation should have failed")
            case ChangelogFailure(logs) =>
                assert(logs.contains("required at least: MinorUpdate"))
    
    test("Allow adding new library in minor update"):
        val change = LibraryChange("example", 
            Version(1,0,0) -> Version(1,1,0), 
            baseDeps -> (baseDeps :+ "com.lihaoyi::upickle::3.1.0")
        )
        val result = ChangelogTest.runChangelog(change, overwrite = true)
        result match
            case ChangelogSuccess(out, changelogs) =>
                assert(changelogs.exists((_, changelog) => 
                    changelog.directChanges.exists(c => c match
                        case Added(Dep(s"com.lihaoyi:upickle$_", Version(3,1,0,_), _), _) => true
                        case _ => false
                    )
                ))
            case ChangelogFailure(logs) =>
                fail("Changelog generation failed: " + logs)
    
    test("Disallow removing library in minor update"):
        val change = LibraryChange("example", 
            Version(1,0,0) -> Version(1,1,0), 
            (baseDeps :+ "com.lihaoyi::upickle::3.0.0") -> baseDeps
        )
        val result = ChangelogTest.runChangelog(change, overwrite = true)
        result match
            case ChangelogSuccess(out, changelogs) =>
                fail("Changelog generation should have failed")
            case ChangelogFailure(logs) =>
                assert(logs.contains("required at least: MajorUpdate"))
    
    test("Allow removing library in major update"):
        val change = LibraryChange("example", 
            Version(1,0,0) -> Version(2,0,0), 
            (baseDeps :+ "com.lihaoyi::upickle::3.0.0") -> baseDeps
        )
        val result = ChangelogTest.runChangelog(change, overwrite = true)
        result match
            case ChangelogSuccess(out, changelogs) =>
                assert(changelogs.exists((_, changelog) => 
                    changelog.directChanges.exists(c => c match
                        case Removed(Dep(s"com.lihaoyi:upickle$_", Version(3,0,0,_), _), _) => true
                        case _ => false
                    )
                ))
            case ChangelogFailure(logs) =>
                fail("Changelog generation failed: " + logs)

    test("Disallow direct major dep change in minor update"):
        val change = LibraryChange("example", 
            Version(1,0,0) -> Version(1,1,0), 
            (baseDeps :+ "com.lihaoyi::upickle::2.0.0") -> (baseDeps :+ "com.lihaoyi::upickle::3.0.0")
        )
        val result = ChangelogTest.runChangelog(change, overwrite = true)
        result match
            case ChangelogSuccess(out, changelogs) =>
                fail("Changelog generation should have failed")
            case ChangelogFailure(logs) =>
                assert(logs.contains("required at least: MajorUpdate"))

    test("Disallow minor dep change in patch update"):
        val change = LibraryChange("example", 
            Version(1,0,0) -> Version(1,0,1), 
            (baseDeps :+ "com.lihaoyi::upickle::3.0.0") -> (baseDeps :+ "com.lihaoyi::upickle::3.1.0")
        )
        val result = ChangelogTest.runChangelog(change, overwrite = true)
        result match
            case ChangelogSuccess(out, changelogs) =>
                fail("Changelog generation should have failed")
            case ChangelogFailure(logs) =>
                assert(logs.contains("required at least: MinorUpdate"))
    
    test("Disallow transitive major dep change in minor update"):
        val change = LibraryChange("example", 
            Version(1,0,0) -> Version(1,1,0), 
            (baseDeps :+ "com.lihaoyi::os-lib::0.8.1") -> (baseDeps :+ "com.lihaoyi::os-lib::0.9.0")
        )
        val result = ChangelogTest.runChangelog(change, skip = List("js"))
        result match
            case ChangelogSuccess(out, changelogs) =>
                fail("Changelog generation should have failed")
            case ChangelogFailure(logs) =>
                assert(logs.contains("required at least: MajorUpdate"))
    
    test("Allow major milestone change in major milestone update"):
        val change = LibraryChange("example", 
            Version(1,0,0,Some("M2")) -> Version(1,0,0,Some("M3")), 
            (baseDeps :+ "com.lihaoyi::upickle::3.0.0-M1") -> (baseDeps :+ "com.lihaoyi::upickle::3.0.0-M2")
        )
        val result = ChangelogTest.runChangelog(change, overwrite = true)
        result match
            case ChangelogSuccess(out, changelogs) =>
                ()
            case ChangelogFailure(logs) =>
                fail("Changelog generation failed: " + logs)
    
    test("Disallow major milestone change in minor milestone update"):
        val change = LibraryChange("example", 
            Version(1,1,0,Some("M2")) -> Version(1,1,0,Some("M3")), 
            (baseDeps :+ "com.lihaoyi::upickle::3.0.0-M1") -> (baseDeps :+ "com.lihaoyi::upickle::3.0.0-M2")
        )
        val result = ChangelogTest.runChangelog(change, overwrite = true)
        result match
            case ChangelogSuccess(out, changelogs) =>
                fail("Changelog generation should have failed")
            case ChangelogFailure(logs) =>
                assert(logs.contains("required at least: MajorUpdate"))
    
    test("Dissalow rollback of minor version in minor update"):
        val change = LibraryChange("example", 
            Version(1,0,0) -> Version(1,1,0), 
            (baseDeps :+ "com.lihaoyi::upickle::3.1.0") -> (baseDeps :+ "com.lihaoyi::upickle::3.0.0")
        )
        val result = ChangelogTest.runChangelog(change, overwrite = true)
        result match
            case ChangelogSuccess(out, changelogs) =>
                fail("Changelog generation should have failed")
            case ChangelogFailure(logs) =>
                assert(logs.contains("required at least: MajorUpdate"))
    
    test("Allow rollback of minor version in major update"):
        val change = LibraryChange("example", 
            Version(1,0,0) -> Version(2,0,0), 
            (baseDeps :+ "com.lihaoyi::upickle::3.1.0") -> (baseDeps :+ "com.lihaoyi::upickle::3.0.0")
        )
        val result = ChangelogTest.runChangelog(change, overwrite = true)
        result match
            case ChangelogSuccess(out, changelogs) =>
                ()
            case ChangelogFailure(logs) =>
                fail("Changelog generation failed: " + logs)

    
    test("Generate human readable changelog"):
        val change = LibraryChange("example", 
            Version(1,0,0) -> Version(1,1,0), 
            (baseDeps :+ "com.lihaoyi::upickle::3.0.0") -> (baseDeps :+ "com.lihaoyi::upickle::3.1.0")
        )
        val result = ChangelogTest.runChangelog(change, overwrite = true)
        result match
            case ChangelogSuccess(out, changelogs) =>
                val changelog = changelogs.find(_._1 == "example_1.1.0_3_changelog.json").get._2
                val humanReadable = changelog.toMd
                assert(humanReadable.contains(
                    """|## Changes to direct dependencies
                       | - Updated `com.lihaoyi:upickle_3:3.0.0` from `3.0.0` to `3.1.0` under `com.example:example_3:1.1.0`""".stripMargin))
            case ChangelogFailure(logs) =>
                fail("Changelog generation failed: " + logs)
    
object ChangelogTest:
    case class LibraryChange(id: String, versionChange: (Version, Version), depChange: (List[String], List[String]))
    trait ChangelogOutput
    case class ChangelogSuccess(processOut: String, changelogs: List[(String,Changelog)]) extends ChangelogOutput
    case class ChangelogFailure(processOut: String) extends ChangelogOutput

    def runChangelog(change: LibraryChange, pregeneratedChangelod: Option[LibraryChange] = None, overwrite: Boolean = false, skip: List[String] = Nil): ChangelogOutput = 
        publish(change.id, change.versionChange._1.toString, change.depChange._1, skip)
        val fileWithChanges = generateConfigFile(change.id, change.versionChange._2.toString, change.depChange._2)
        val outputDir = os.temp.dir()
        val runResult = os.proc("scala-cli", "checks", "--", "--module-name", change.id, "--file", fileWithChanges.toString, if overwrite then Seq("--overwrite", "--yes") else Seq.empty, skip.flatMap(s => List("--skip", s))).call(
            env = Map(
                "TOOLKIT_VERSION_RELEASE" -> change.versionChange._1.toString,
                "TOOLKIT_VERSION_DEVELOPMENT" -> change.versionChange._2.toString,
                "TOOLKIT_ORG" -> "com.example",
                "CHANGELOG_DIR" -> outputDir.toString(),
            ),
            check = false
        )
        if(runResult.exitCode == 0) then
            val changelogs = os.list(outputDir / "json").map(path => (path, os.read(path))).map { case (path, content) => (path.last, read[Changelog](content))}.toList
            ChangelogSuccess(runResult.out.text(), changelogs)
        else
            ChangelogFailure(runResult.out.text())



    private def generateConfigFile(id: String, version: String, deps: List[String]): os.Path = 
        // scala-cli config file write
        os.temp(s"""
        |//> using scala 2.13, 3
        |//> using publish.name "$id"
        |${deps.map(d => s"//> using lib $d").mkString("\n")}
        |//> using publish.version "$version"
        |//> using publish.organization "com.example"
        | """.stripMargin, suffix = ".scala")

    private def publish(id: String, version: String, deps: List[String], skip: List[String] = Nil) = 
        val file = generateConfigFile(id, version, deps)
        scoped {
            val publishJvm = fork(if !skip.contains("jvm") then os.proc("scala-cli", "--power", "publish", "local", "--cross", file).call() else ())
            val publishNative = fork(if !skip.contains("native") then os.proc("scala-cli", "--power", "publish", "local", "--native", "--cross", file).call() else ())
            val publishJs = fork(if !skip.contains("js") then os.proc("scala-cli", "--power", "publish", "local", "--js", "--cross", file).call() else ())
            (publishJvm.join(), publishNative.join(), publishJs.join())
        }