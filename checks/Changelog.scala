import scala.util.Try
import coursier.*
import coursier.given
import coursier.graph.DependencyTree
import scala.util.matching.Regex
import upickle.default.*
import scala.io.StdIn.readLine
import Dependencies.*
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import ox.*
import caseapp._

case class Params(file: String, moduleName: String, overwrite: Boolean = false, yes: Boolean = false, skip: List[String] = Nil, moduleDep: Option[String] = None)

var params: Params = _

private def publish(flag: Option[String]) = 
    val file = params.moduleDep match
      case None => params.file
      case Some(dep) =>
        val copy = os.temp(os.read(os.pwd / params.file), suffix = ".scala")
        val moduleDep = s"${Config.organization}::$dep::${Config.developmentVersion}"
        os.write.append(copy, s"\n//> using dep ${moduleDep}")
        copy.toString
    os.proc("scala-cli", "--power", "publish", "local", "--cross", flag.map(f => s"--$f").toList, "--organization", Config.organization, "--version", Config.developmentVersion.toString, file).call()

@main
def main(args: String*) =
  Utility.requireCmd("scala-cli")
  params = CaseApp.parse[Params](args.toSeq) match 
    case Left(err) => 
      println(err)
      sys.exit(1)
    case Right((params, leftover)) => params

  val platformsSkipped = Config.platforms.filterNot(p => params.skip.contains(p._1)).toList 

  println("Publishing locally to validate the dependency tree...")

  val trees = scoped {
    forkAllHold(
      for
        (_, option, _) <- platformsSkipped
      yield () => publish(option)
    ).join()

    forkAllHold(
      for 
        crossVersion <- Config.crossVersions
        (_, _, platform) <- platformsSkipped
        versionSuffix = platform.map(p => s"${p}_").getOrElse("") + crossVersion
        previousSnapshot = fork(Dep.resolve(Config.organization, params.moduleName, versionSuffix, Config.releaseVersion))
        currentSnapshot = fork(Dep.resolve(Config.organization, params.moduleName, versionSuffix, Config.developmentVersion))
      yield () => (versionSuffix, previousSnapshot.join(), currentSnapshot.join())
    ).join()
  }

  trees.foreach((checkTree _).tupled)
end main

def checkTree(releasedVersion: String, previousSnapshot: Dep, currentSnapshot: Dep) = 
  println(s"\nChecking tree for $releasedVersion...")

  val summary = SnapshotDiffValidator.summarize(previousSnapshot, currentSnapshot)
  if summary.illegalDiffs.nonEmpty then
    println(s"For $releasedVersion found diffs illegal to introduce on this update type: ${summary.updateType}")
    println(s"Illegal diffs: \n${summary.illegalDiffs.mkString(" - ", "\n - ", "\n")}")
    if params.overwrite then
      println("Could not generate changelog due to illegal diffs.")
    println("Exiting with failure status (1)")
    sys.exit(1)

  val diffsFound = summary.diffs.nonEmpty

  if diffsFound then
    println("Found diffs in development version: \n" + summary.diffs.mkString(" - ", "\n - ", ""))
  else 
    println("No diffs found")

  val generatedChangelog = Changelog.generate(params.moduleName, summary.diffs)
  val changelogDir = Config.changelogDir / Config.developmentVersion.toString
  val baseFileName = s"${params.moduleName}_${Config.developmentVersion}_${releasedVersion}_changelog"
  val changelogJson = changelogDir / "json" / s"${baseFileName}.json"
  if !os.exists(changelogJson) then 
    println("No changelog found, comparing with empty changelog.")
    os.makeDir.all(changelogDir / "json")
  val parsedChangelog = if(os.exists(changelogJson)) then read[Changelog](os.read(changelogJson)) else Changelog(params.moduleName, Set.empty, Set.empty)
  def changelogsDiff = generatedChangelog.diff(parsedChangelog)

  if changelogsDiff.nonEmpty then
    println("Found diffs in changelog: \n" + changelogsDiff.get)
    if !params.overwrite then
      println("Exiting with failure status (1). Please run with --overwrite to overwrite the expected changelog.")
      sys.exit(1)
    else
      val input = if(params.yes) then "y" else readLine("Overwrite symbols? (y/N)")
      if input == "y" || input == "Y" then
        os.write.over(changelogJson, write(generatedChangelog))
        val changelogReadable = generatedChangelog.toMd
        val changelogMd = changelogDir / s"${baseFileName}.md"
        os.write.over(changelogMd, changelogReadable)
        os.write.append(changelogMd, "\n## Full dependency tree\n")
        os.write.append(changelogMd, currentSnapshot.toMdTree + "\n")
        println("Overwritten")
      else
        println("Changes rejected")
        sys.exit(1)
  else 
    println("No diffs found in changelog")

object SnapshotDiffValidator:

  def summarize(previous: Dep, current: Dep): DiffSummary = 
    val versionDiff = Version.compareVersions(previous.version, current.version)

    def traverseDep(oldDep: Option[Dep], newDep: Option[Dep], enteredFrom: Option[Dep] = None): List[Diff] =
      def traverseDepTupled(enteredFrom: Dep)(pair: (Option[Dep], Option[Dep])) = traverseDep(pair._1, pair._2, Some(enteredFrom))
      (oldDep, newDep) match
        case (Some(oldDep), Some(newDep)) =>
          if oldDep.version == newDep.version then Nil
          else
            val diff = DepUpdated(oldDep, newDep, enteredFrom)
            val pairs = oldDep.deps.map(dep => (Some(dep), newDep.deps.find(_.id == dep.id)))
            val newDeps = newDep.deps.filterNot(dep => oldDep.deps.exists(_.id == dep.id)).map(dep => (None, Some(dep)))
            val diffs = pairs.flatMap(traverseDepTupled(newDep)) ++ newDeps.flatMap(traverseDepTupled(newDep))
            diff :: diffs
        case (Some(oldDep), None) => Removed(oldDep, enteredFrom) :: oldDep.deps.flatMap(dep => traverseDep(Some(dep), None, Some(oldDep))).toList
        case (None, Some(newDep)) => Added(newDep, enteredFrom) :: newDep.deps.flatMap(dep => traverseDep(None, Some(dep), Some(newDep))).toList
        case _ => Nil
    
    val diffs: List[Diff] = traverseDep(Some(previous), Some(current))
    val illegalDiffs: List[IllegalDiff] = diffs
      .map(diff => IllegalDiff(diff, getLeastOrderLegalUpdate(versionDiff, diff)))
      .filter(_.leastOrderLegalUpdate > versionDiff)
    DiffSummary(versionDiff, diffs, illegalDiffs)
  

  def getLeastOrderLegalUpdate(versionDiff: VersionDiff, diff: Diff): VersionDiff =
    diff match 
      case _: Removed => MajorUpdate
      case _: Added => MinorUpdate
      case DepUpdated(oldDep, newDep, _) =>
        Version.compareVersions(oldDep.version, newDep.version)
        
object Utility:
  def requireCmd(cmd: String): Unit =
      if Try(os.proc("which", cmd).call()).isFailure then
          println(s"Please install $cmd")
          sys.exit(1)
