#!/usr/bin/env -S scala-cli shebang
//> using scala 3.3
//> using toolkit 0.1.7
//> using dep io.get-coursier:coursier_2.13:2.1.4
//> using file Dependencies.scala
//> using file Config.scala

import scala.util.Try
import coursier.*
import coursier.given
import coursier.graph.DependencyTree
import scala.util.matching.Regex
import upickle.default.*
import scala.io.StdIn.readLine
import Dependencies.*

Utility.requireCmd("scala-cli")

case class DiffSummary(updateType: VersionDiff, diffs: List[Diff], illegalDiffs: List[IllegalDiff])
sealed trait Diff derives ReadWriter:
  def under: Option[Dep]
case class Added(newDep: Dep, under: Option[Dep]) extends Diff:
  override def toString: String = s"Added `$newDep` ${under.fold("")(u => s"under `$u`")}"
case class Removed(oldDep: Dep, under: Option[Dep]) extends Diff:
  override def toString: String = s"Removed `$oldDep` ${under.fold("")(u => s"under `$u`")}"
case class DepUpdated(oldDep: Dep, newDep: Dep, under: Option[Dep]) extends Diff:
  override def toString: String = 
    s"Updated `$oldDep` from `${oldDep.version}` to `${newDep.version}` ${under.fold("")(u => s"under `$u`")}"

object Diff:
  def getOldDep(diff: Diff) = diff match
    case Added(newDep, _) => None
    case Removed(oldDep, _) => Some(oldDep)
    case DepUpdated(oldDep, _, _) => Some(oldDep)

case class IllegalDiff(diff: Diff, leastOrderLegalUpdate: VersionDiff):
  override def toString: String = s"$diff (required at least: $leastOrderLegalUpdate)"

case class Params(file: String, overwrite: Boolean)

val params = args match
    case Array(file) => Params(file, false)
    case Array(file, "--overwrite") => Params(file, true)
    case _ => throw new Exception("Usage: ./scripts/changelog.sc <file> [overwrite]")

println("Publishing locally to validate the dependency tree...")
os.proc("scala-cli", "--power", "publish", "local", "--cross", "--organization", Config.organization, "--version", Config.developmentVersion.toString, params.file).call()

Config.crossVersions.foreach(checkTree)

def checkTree(crossVersion: String) = 

  val previousSnapshot = Dep.resolve(Config.organization, Config.name, crossVersion, Config.releaseVersion)
  val currentSnapshot = Dep.resolve(Config.organization, Config.name, crossVersion, Config.developmentVersion)

  val summary = SnapshotDiffValidator.summarize(previousSnapshot, currentSnapshot)
  if summary.illegalDiffs.nonEmpty then
    println("Found diffs illegal to introduce on this update type: " + summary.updateType)
    println(s"Illegal diffs: \n ${summary.illegalDiffs.mkString(" - ", "\n - ", "\n")}")
    if params.overwrite then
      println("Could not generate changelog due to illegal diffs.")
    println("Exiting with failure status (1)")
    sys.exit(1)

  val diffsFound = summary.diffs.nonEmpty

  if diffsFound then
    println("Found diffs in development version: \n" + summary.diffs.mkString(" - ", "\n - ", "\n"))
  else 
    println("No diffs found")

  val generatedChangelog = Changelog.generate(summary.diffs)
  val changelogJson = os.pwd / "changelog" / "json" / s"${Config.developmentVersion}_changelog_${crossVersion}.json"
  if !os.exists(changelogJson) then 
    println("No changelog found, comparing with empty changelog.")
    os.makeDir.all(os.pwd / "changelog" / "json")
  val parsedChangelog = if(os.exists(changelogJson)) then read[Changelog](os.read(changelogJson)) else Changelog(Set.empty, Set.empty)
  def changelogsDiff = generatedChangelog.diff(parsedChangelog)

  if changelogsDiff.nonEmpty then
    println("Found diffs in changelog: \n" + changelogsDiff.get)
    if !params.overwrite then
      println("Exiting with failure status (1). Please run with --overwrite to overwrite the expected changelog.")
      sys.exit(1)
    else
      val input = readLine("Overwrite symbols? (y/N)")
      println(s"Input: $input")
      if input == "y" || input == "Y" then
        os.write.over(changelogJson, write(generatedChangelog))
        val changelogReadable = generatedChangelog.toMd
        val changelogMd = os.pwd / "changelog" / s"${Config.developmentVersion}_changelog_${crossVersion}.md"
        os.write.over(changelogMd, changelogReadable)
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
  

case class Changelog(directChanges: Set[Diff], indirectChanges: Set[Diff]) derives ReadWriter:

  def diff(other: Changelog): Option[String] = 
    if other == this then
      None
    else
      val directAdded = directChanges.filterNot(other.directChanges.contains)
      val directRemoved = other.directChanges.filterNot(directChanges.contains)
      val indirectAdded = indirectChanges.filterNot(other.indirectChanges.contains)
      val indirectRemoved = other.indirectChanges.filterNot(indirectChanges.contains)
      val directAddedString = if directAdded.isEmpty then "" else s" - Direct changes added:\n${directAdded.mkString("   - ", "\n   - ", "")}\n"
      val directRemovedString = if directRemoved.isEmpty then "" else s" - Direct changes removed:\n${directRemoved.mkString("   - ", "\n   - ", "")}\n"
      val indirectAddedString = if indirectAdded.isEmpty then "" else s" - Indirect changes added:\n${indirectAdded.mkString("   - ", "\n   - ", "")}\n"
      val indirectRemovedString = if indirectRemoved.isEmpty then "" else s" - Indirect changes removed:\n${indirectRemoved.mkString("   - ", "\n   - ", "")}\n"
      Some(directAddedString + directRemovedString + indirectAddedString + indirectRemovedString)
    
  def toMd: String = 
    val directChangesSection = if directChanges.isEmpty then "" else
      val directChangesHeader = "## Changes to direct dependencies"
      val directChangesList = directChanges.map(diff => s" - ${diff.toString}").toList.sorted
      (directChangesHeader :: directChangesList).mkString("\n")
    val indirectChangesSection = if indirectChanges.isEmpty then "" else
      val indirectChangesHeader = "## Changes to transitive dependencies"
      val indirectChangesList = indirectChanges.map(diff => s" - ${diff.toString}").toList.sorted
      (indirectChangesHeader :: indirectChangesList).mkString("\n")
    val header = s"# Changelog for ${Config.name} ${Config.developmentVersion}"
    header + "\n" + directChangesSection + "\n" + indirectChangesSection

object Changelog:
  def generate(diffs: List[Diff]): Changelog =
    val parentDiff = diffs.find(_.under.isEmpty).getOrElse(throw new Exception("No parent diff found"))
    val parentId = Diff.getOldDep(parentDiff).getOrElse(throw new Exception(s"Illegal parent diff: ${parentDiff}")).id
    val (directChanges, indirectChanges) = diffs.partition(_.under.exists(_.id == parentId))
    Changelog(directChanges.toSet, indirectChanges.toSet - parentDiff)
