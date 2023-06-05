#!/usr/bin/env -S scala-cli shebang
//> using toolkit 0.1.7
//> using scala 3.3
//> using dep io.get-coursier:coursier_2.13:2.1.4
//> using file Dependencies.scala
//> using file Config.scala

import scala.util.Try
import coursier.*
import coursier.given
import coursier.graph.DependencyTree
import scala.util.matching.Regex
import upickle.default.*

import Dependencies.*

Utility.requireCmd("scala-cli")

case class DiffSummary(updateType: VersionDiff, diffs: List[Diff], illegalDiffs: List[IllegalDiff])
sealed trait Diff
case class Added(newDep: Dep, under: Option[Dep]) extends Diff 
case class Removed(oldDep: Dep, under: Option[Dep]) extends Diff
case class DepUpdated(oldDep: Dep, newDep: Dep, under: Option[Dep]) extends Diff

case class IllegalDiff(diff: Diff, leastOrderLegalUpdate: VersionDiff):
  override def toString: String = s"$diff (required at least: $leastOrderLegalUpdate)"

case class Params(file: String, version: Version, overwrite: Boolean)

val params = args match
    case Array(file, VersionString(version)) => Params(file, version, false)
    case Array(file, VersionString(version), "--overwrite") => Params(file, version, true)
    case _ => throw new Exception("Usage: ./scripts/deptree.sc <file> <version> [overwrite]")

println("Publishing locally to validate the dependency tree...")
os.proc("scala-cli", "--power", "publish", "local", "--cross", "--organization", Config.organization, "--version", params.version.toString, params.file).call()

Config.crossVersions.foreach(checkTree)

def checkTree(crossVersions: String) = 
  val resolution = Resolve()
    .addDependencies(Dependency(Module(Organization(Config.organization), ModuleName(Config.name + "_" + crossVersions)), params.version.toString))
    .run()

  val head = DependencyTree(resolution).head
  val depTree = makeDepTree(head)

  val previousSnapshot = read[Dep](os.read(os.pwd / "scripts" / "expected" / s"deptree_${crossVersions}.json"))
  val currentSnapshot = Dep(depTree.id, params.version, depTree.deps)

  val summary = SnapshotDiffValidator.summarize(previousSnapshot, currentSnapshot)
  if summary.illegalDiffs.nonEmpty then
    println("Found diffs illegal to introduce on this update type: " + summary.updateType)
    println(s"Illegal diffs: \n ${summary.illegalDiffs.mkString(" - ", "\n - ", "\n")}")
    if params.overwrite then
      println("Could not overwrite the expected snapshot due to illegal diffs")
    sys.exit(1)

  val diffsFound = summary.diffs.nonEmpty

  if diffsFound then
    println("Found diffs: \n" + summary.diffs.mkString(" - ", "\n - ", "\n"))
  else 
    println("No diffs found")
  
  if !params.overwrite && diffsFound then
    println("Exiting with failure status (1). Please run with --overwrite to overwrite the expected snapshot")
    sys.exit(1)
  else if diffsFound then
    println("Overwrite symbols? (y/N)")
    val input = scala.io.StdIn.readLine()
    if input == "y" || input == "Y" then
      os.write.over(os.pwd / "scripts" / "expected" / s"deptree_${crossVersions}.json", write(currentSnapshot))
      println("Overwritten")
    else
      println("Changes rejected")
      sys.exit(1)
  

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