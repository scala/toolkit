import upickle.default.*
import scala.io.StdIn
import Dependencies.*
import ChangelogException.*

class ChangelogChecker(config: Config, versionExceptions: Seq[String], overwrite: Boolean, yes: Boolean):
  def check(file: os.Path, moduleName: String, platform: Platform, firstRelease: Boolean = false): Unit =
    println("Publishing locally to validate the dependency tree...")
    publish(file, platform)
    for languageVersion <- Seq("3", "2.13") do
      val binaryVersion = s"${platform.binarySuffix}_$languageVersion"
      val previousSnapshot = 
        if firstRelease then Dep(moduleName + binaryVersion, config.releaseVersion, List.empty)
        else Dep.resolve(config.organization, moduleName, binaryVersion, config.releaseVersion)
      val currentSnapshot = Dep.resolve(config.organization, moduleName, binaryVersion, config.developmentVersion)
      checkTree(moduleName)(binaryVersion, previousSnapshot, currentSnapshot)

  private def publish(file: os.Path, platform: Platform) = 
    os.proc(
      Seq("scala-cli", "--power", "publish", "local", "--cross"),
      platform.scalaCliOptions,
      Seq("--organization", config.organization),
      Seq("--project-version", config.developmentVersion.toString),
      Seq("--native-version", "0.5.10"),
      file
    ).call(stderr = os.Pipe) // mute warnings

  private def checkTree(moduleName: String)(binaryVersion: String, previousSnapshot: Dep, currentSnapshot: Dep): Unit = 
    println(s"\nChecking tree for binary version $binaryVersion...")

    val summary = SnapshotDiffValidator.summarize(previousSnapshot, currentSnapshot)
    if summary.illegalDiffs.nonEmpty then
      println(s"Illegal diffs for ${summary.updateType}: \n${summary.illegalDiffs.mkString(" - ", "\n - ", "\n")}")
      if versionExceptions.contains(currentSnapshot.version.toString) then
        println("Ignoring illegal diffs because " +  currentSnapshot.version.toString + " is found in exceptions.txt")
      else throw IllegalDiffs()

    val diffsFound = summary.diffs.nonEmpty

    if diffsFound then
      println("All diffs are: \n" + summary.diffs.mkString(" - ", "\n - ", ""))
    else 
      println("No diffs found")

    val generatedChangelog = Changelog.generate(moduleName, summary)
    val changelogDir = config.outputDir / config.developmentVersion.toString
    val baseFileName = s"${moduleName}_${config.developmentVersion}${binaryVersion}_changelog"
    val changelogJson = changelogDir / "json" / s"${baseFileName}.json"
    val parsedChangelog = 
      if !os.exists(changelogJson) then 
        println("No changelog found, comparing with empty changelog.")
        os.makeDir.all(changelogDir / "json")
        Changelog(moduleName, Set.empty, Set.empty, Map.empty)
      else read[Changelog](os.read(changelogJson))
    def changelogsDiff = generatedChangelog.diff(parsedChangelog)

    if changelogsDiff.nonEmpty then
      println("Changelog file is outdated: \n" + changelogsDiff.get)
      if !overwrite then throw AlreadyExists()
      else
        val input = if yes then "y" else StdIn.readLine("Overwrite symbols? (y/N)")
        if input == "y" || input == "Y" then
          os.write.over(changelogJson, write(generatedChangelog))
          val changelogReadable = generatedChangelog.toMd
          val changelogMd = changelogDir / s"${baseFileName}.md"
          os.write.over(changelogMd, changelogReadable)
          os.write.append(changelogMd, "\n## Full dependency tree\n")
          os.write.append(changelogMd, currentSnapshot.toMdTree + "\n")
          println("Overwritten")
        else throw UserRejection()
    else 
      println("Changelog file is up-to-date")

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
      case _: Removed => VersionDiff.MajorUpdate
      case _: Added => VersionDiff.MinorUpdate
      case DepUpdated(oldDep, newDep, _) =>
        Version.compareVersions(oldDep.version, newDep.version)