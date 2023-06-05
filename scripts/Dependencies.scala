import scala.util.Try
import scala.util.matching.Regex
import upickle.default.*
import coursier.graph.DependencyTree
import Dependencies.*

object Dependencies:
  case class Version(major: Int, minor: Int, patch: Int, suffix: Option[String]) extends Ordered[Version] derives ReadWriter:
    def compare(that: Version): Int =
    Ordering[(Int, Int, Int, Option[String])].compare((this.major, this.minor, this.patch, this.suffix), (that.major, that.minor, that.patch, that.suffix))
    override def toString: String = s"$major.$minor.$patch"
    def getDiff(that: Version): VersionDiff = Version.compareVersions(this, that)

  object Version:
    /**
     * Compares two versions and returns the type of update that is required to go from oldVersion to newVersion.
     * Takes into account that versions may be rolled back. For example:
     *   - 1.0.1 -> 1.0.0 is a patch update
     *   - 1.1.0 -> 1.0.0 is a major update, as it may break backwards compatibility
     * pre-release suffixes are also taken into account. The required version update is as great as the version bump 
     * for which the pre-release is published. For example
     *  - 1.0.0-M1 -> 1.0.0-M2 is a major update. The same as 1.0.0-M2 -> 1.0.0
     *  - 1.1.2-M2 -> 1.1.2-M3 is a patch update
     */
    def compareVersions(oldVersion: Version, newVersion: Version): VersionDiff =
      if oldVersion.major != newVersion.major then MajorUpdate
      else if oldVersion.minor != newVersion.minor then
        if oldVersion.minor < newVersion.minor then MinorUpdate
        else MajorUpdate
      else if oldVersion.patch != newVersion.patch then PatchUpdate
      else if oldVersion.suffix != newVersion.suffix then
        oldVersion match
          case Version(_, 0, 0, _) => MajorUpdate
          case Version(_, _, 0, _) => MinorUpdate
          case _ => PatchUpdate
      else throw new IllegalArgumentException("Versions are the same")


  sealed abstract class VersionDiff(val order: Int) extends Ordered[VersionDiff]:
    def compare(that: VersionDiff): Int = order compare that.order
  case object PatchUpdate extends VersionDiff(0)
  case object MinorUpdate extends VersionDiff(1)
  case object MajorUpdate extends VersionDiff(2)

  object VersionString:
    def unapply(s: String): Option[Version] =
      val regex = """(\d+)\.(\d+)\.(\d+)(-[a-zA-Z\d\.]+)?""".r
      s match
        case regex(major, minor, patch, suffix) => Some(Version(major.toInt, minor.toInt, patch.toInt, Option(suffix).map(_.drop(1))))
        case _ => None

  case class Dep(id: String, version: Version, deps: List[Dep]) derives ReadWriter:
    override def toString: String = s"$id:$version"


  def makeDepTree(tree: DependencyTree): Dep =
    val dep = tree.dependency
    val depId = s"${dep.module.organization.value}:${dep.module.name.value}"
    val versionParsed = VersionString.unapply(dep.version)
    versionParsed match
      case Some(version) => Dep(dep.module.name.value, version, tree.children.map(makeDepTree).toList)
      case None => throw new Exception(s"Could not parse version from $depId:${dep.version}")
    

object Utility:
  def requireCmd(cmd: String): Unit =
      if Try(os.proc("which", cmd).call()).isFailure then
          println(s"Please install $cmd")
          sys.exit(1)
