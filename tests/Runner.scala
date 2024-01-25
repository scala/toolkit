//> using toolkit 0.2.1
//> using dep com.softwaremill.ox::core:0.0.16

import scala.util.Try
import ox.syntax.*

@main
def main(version: String) = 
  Utility.requireCmd("scala-cli")
  val testCases = os.list(os.pwd / "tests" / "cases").filter(_.ext == "sc")
  testCases.foreachPar(16)(runTest(_, version, None))
  testCases.foreachPar(16)(runTest(_, version, Some("--native")))
  testCases.foreachPar(16)(runTest(_, version, Some("--js")))

def runTest(test: os.Path, toolkitVersion: String, extraOpt: Option[String]): Unit = 
  val testName = test.last
  val testRunned = os.proc("scala-cli", "run", "--toolkit", toolkitVersion, extraOpt.toSeq, test).call()
  val outputRaw = testRunned.out.text()
  val expectedOutputLines = getExpectedOutput(test)
  val outputLines = outputRaw.linesIterator.toList.map(_.trim)
  val output = outputLines.mkString("\n")
  if output != expectedOutputLines then
    println(s"Test $testName failed")
    println(s"Expected output: $expectedOutputLines")
    println(s"Actual output: $output")
    sys.exit(1)

private val outputRegex = """(.*)//> (.*)""".r
def getExpectedOutput(test: os.Path): String = 
  val testContent = os.read(test)
  val lines = testContent.linesIterator.toList
  val outputLines = lines.collect {
    case outputRegex(_, line) => line
  }
  outputLines.mkString("\n")

object Utility:
  def requireCmd(cmd: String): Unit =
      if Try(os.proc("which", cmd).call()).isFailure then
          println(s"Please install $cmd")
          sys.exit(1)
