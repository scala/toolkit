import Dependencies.*

@main
def main(args: String*) =
  try
    Utility.requireCmd("scala-cli")
    val overwrite = args.contains("--overwrite")
    val yes = args.contains("--yes")
    val config = Config.loadFromEnv
    val exceptionsPath = os.pwd / "changelog" / "exceptions.txt"
    val exceptions =
      if os.exists(exceptionsPath) then 
        os.read(exceptionsPath).split("\n").map(_.trim).filter(_.nonEmpty).toSeq
      else Seq.empty
    val changelogChecker = ChangelogChecker(Config.loadFromEnv, exceptions, overwrite, yes)
    changelogChecker.check(os.pwd / "Toolkit.scala", "toolkit", Platform.Jvm)
    changelogChecker.check(os.pwd / "Toolkit.scala", "toolkit", Platform.Native)
    changelogChecker.check(os.pwd / "Toolkit.js.scala", "toolkit", Platform.Js)
    val toolkitTestFile = addToolkitDependency(os.pwd / "ToolkitTest.scala", config.organization, config.developmentVersion)
    changelogChecker.check(toolkitTestFile, "toolkit-test", Platform.Jvm)
    changelogChecker.check(toolkitTestFile, "toolkit-test", Platform.Native)
    changelogChecker.check(toolkitTestFile, "toolkit-test", Platform.Js)
  catch
    case e: ChangelogException =>
      Console.err.println("Exiting with failure status (1). " + e.getMessage)
      sys.exit(1)

private def addToolkitDependency(file: os.Path, organization: String, version: Version): os.Path =
  val copy = os.temp(os.read(file), suffix = ".scala")
  val moduleDep = s"$organization::toolkit::$version"
  os.write.append(copy, s"\n//> using dep ${moduleDep}")
  copy
