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
    test("Generate a changelog"):
        val change = LibraryChange("example", 
            Version(1,0,0) -> Version(1,1,0), 
            (baseDeps :+ "com.lihaoyi::upickle::3.0.0") -> (baseDeps :+ "com.lihaoyi::upickle::3.1.0")
        )
        val result = ChangelogTest.runChangelog(change, overwrite = true)
        result match
            case ChangelogSuccess(out, changelogs) =>
                println(changelogs)
            case ChangelogFailure(logs) =>
                fail("Changelog generation failed: " + logs)

object ChangelogTest:
    case class LibraryChange(id: String, versionChange: (Version, Version), depChange: (List[String], List[String]))
    trait ChangelogOutput
    case class ChangelogSuccess(processOut: String, changelogs: List[(String,Changelog)]) extends ChangelogOutput
    case class ChangelogFailure(processOut: String) extends ChangelogOutput

    def runChangelog(change: LibraryChange, pregeneratedChangelod: Option[LibraryChange] = None, overwrite: Boolean = false): ChangelogOutput = 
        publish(change.id, change.versionChange._1.toString, change.depChange._1)
        val fileWithChanges = generateConfigFile(change.id, change.versionChange._2.toString, change.depChange._2)
        val outputDir = os.temp.dir()
        val runResult = os.proc("scala-cli", "checks", "--", "--file", fileWithChanges.toString, if overwrite then Seq("--overwrite", "--yes") else Seq.empty).call(
            env = Map(
                "TOOLKIT_VERSION_RELEASE" -> change.versionChange._1.toString,
                "TOOLKIT_VERSION_DEVELOPMENT" -> change.versionChange._2.toString,
                "TOOLKIT_ORG" -> "com.example",
                "TOOLKIT_NAME" -> change.id,
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

    private def publish(id: String, version: String, deps: List[String]) = 
        val file = generateConfigFile(id, version, deps)
        scoped {
            val publishJvm = fork(os.proc("scala-cli", "--power", "publish", "local", "--cross", file).call())
            val publishNative = fork(os.proc("scala-cli", "--power", "publish", "local", "--native", "--cross", file).call())
            val publishJs = fork(os.proc("scala-cli", "--power", "publish", "local", "--js", "--cross", file).call())
            (publishJvm.join(), publishNative.join(), publishJs.join())
        }