import scala.util.Try
import scala.util.matching.Regex
import upickle.default.*
import coursier.graph.DependencyTree
import Dependencies.*
import coursier.*

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


case class Changelog(moduleName: String, directChanges: Set[Diff], indirectChanges: Set[Diff]) derives ReadWriter:

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
      val directChangesHeader = "\n## Changes to direct dependencies"
      val directChangesList = directChanges.map(diff => s" - ${diff.toString}").toList.sorted
      (directChangesHeader :: directChangesList).mkString("\n") + "\n"
    val indirectChangesSection = if indirectChanges.isEmpty then "" else
      val indirectChangesHeader = "\n## Changes to transitive dependencies"
      val indirectChangesList = indirectChanges.map(diff => s" - ${diff.toString}").toList.sorted
      (indirectChangesHeader :: indirectChangesList).mkString("\n") + "\n"
    val header = s"# Changelog for ${moduleName} ${Config.developmentVersion}"
    header + "\n" + directChangesSection + indirectChangesSection

object Changelog:
  def generate(moduleName: String, diffs: List[Diff]): Changelog =
    val parentDiff = diffs.find(_.under.isEmpty).getOrElse(throw new Exception("No parent diff found"))
    val parentId = Diff.getOldDep(parentDiff).getOrElse(throw new Exception(s"Illegal parent diff: ${parentDiff}")).id
    val (directChanges, indirectChanges) = diffs.partition(_.under.exists(_.id == parentId))
    Changelog(moduleName, directChanges.toSet, indirectChanges.toSet - parentDiff)