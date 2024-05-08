//> using toolkit 0.2.1

import scala.util.Try
import scala.Console.*

@main
def runTests(version: String) = 
  requireCmd("scala-cli")
  runTestSuite("jvm", version)
  runTestSuite("js", version, "--js")
  runTestSuite("native", version, "--native", "--native-version", "0.4.17")

private def runTestSuite(suiteName: String, version: String, extraOpts: String*): Unit =
  (listTests("shared") ++ listTests(suiteName)).foreach(runTest(suiteName, _, version, extraOpts*))

private def listTests(folderName: String): Seq[os.Path] =
  os.list(os.pwd / "tests" / folderName).filter(_.ext == "sc")

private def runTest(suiteName: String, testFile: os.Path, toolkitVersion: String, extraOpts: String*): Unit =
  val testName = s"$suiteName.${testFile.last}"
  val expectedOutput = getExpectedOutput(testFile)
  
  val testProcess = os.proc("scala-cli", "run", "--toolkit", toolkitVersion, extraOpts, testFile).call(check = false)
  val output = testProcess.out.lines().map(_.trim)

  if testProcess.exitCode != 0 then
    println(s"${RED}Test $testName failed$RESET")
  else if output != expectedOutput then
    println(s"${RED}Test $testName failed$RESET")
    println(s"${RED}  Expected output: $expectedOutput$RESET")
    println(s"${RED}  Output: ${output}$RESET")
  else
    println(s"${GREEN}Test $testName succeeded$RESET")
end runTest

private def getExpectedOutput(test: os.Path): Seq[String] =
  val OutputLine = "(.*)//\\$ (.*)".r
  os.read(test).linesIterator.collect { case OutputLine(_, content) => content.trim }.toSeq


private def requireCmd(cmd: String): Unit =
  if os.proc("which", cmd).call(check = false).exitCode != 0 then
    println(s"${RED}Please install $cmd$RESET")
    sys.exit(1)
