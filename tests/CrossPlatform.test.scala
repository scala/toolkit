//> using toolkit 0.6.0
//> using scala 3.3

import scala.util.Try
import scala.Console.*
import scala.concurrent.duration.Duration

class CrossPlatformTests extends munit.FunSuite:
  requireCmd("scala-cli")
  test("jvm")(publishAndRun("jvm", "1.0.0-SNAPSHOT"))
  test("js")(publishAndRun("js", "1.0.0-SNAPSHOT", "--js"))
  test("native")(publishAndRun("native", "1.0.0-SNAPSHOT", "--native", "--native-version", "0.5.10"))

  override val munitTimeout = Duration(120, "s")

  private def publishAndRun(platform: String, version: String, extraOpts: String*): Unit =
    val toolkitFile = if platform == "js" then os.pwd / "Toolkit.js.scala" else os.pwd / "Toolkit.scala"
    val toolkitTestFile = os.pwd / "ToolkitTest.scala"
    publish(toolkitFile, version, extraOpts)
    publish(toolkitTestFile, version, extraOpts ++ Seq("--dependency", s"org.scala-lang::toolkit::$version"))
    (listTests("shared") ++ listTests(platform)).foreach(runTest(platform, _, version, extraOpts*))

  private def publish(file: os.Path, version: String, extraOpts: Seq[String]): Unit =
    os.proc(
      Seq("scala-cli", "--power", "publish", "local", "--cross"),
      extraOpts,
      Seq("--organization", "org.scala-lang"),
      Seq("--project-version", version),
      file
    ).call(stderr = os.Pipe) // mute warnings

  private def listTests(folderName: String): Seq[os.Path] =
    os.list(os.pwd / "tests" / folderName).filter(_.ext == "sc")

  private def runTest(platform: String, testFile: os.Path, toolkitVersion: String, extraOpts: String*): Unit =
    val testName = s"$platform.${testFile.last}"
    val expectedOutput = getExpectedOutput(testFile)
    println(s"Running $testName")
    
    val testProcess = os.proc("scala-cli", "run", "--scala", "3.3", "--toolkit", toolkitVersion, extraOpts, testFile).call(check = false)
    val output = testProcess.out.lines().map(_.trim)

    if testProcess.exitCode != 0 then
      println(s"${RED}$testName failed$RESET")
    else if output != expectedOutput then
      println(s"${RED}$testName failed$RESET")
      println(s"${RED}  Expected output: $expectedOutput$RESET")
      println(s"${RED}  Output: ${output}$RESET")
  end runTest

  private def getExpectedOutput(test: os.Path): Seq[String] =
    val OutputLine = "(.*)//\\$ (.*)".r
    os.read(test).linesIterator.collect { case OutputLine(_, content) => content.trim }.toSeq

  private def requireCmd(cmd: String): Unit =
    if os.proc("which", cmd).call(check = false).exitCode != 0 then
      println(s"${RED}Please install $cmd$RESET")
      sys.exit(1)
