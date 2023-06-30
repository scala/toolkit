import scala.util.Try
import scala.util.matching.Regex
import upickle.default.*
import coursier.graph.DependencyTree
import Dependencies.*
import coursier.*
import scala.annotation.tailrec

object Dependencies:
  case class Version(major: Int, minor: Int, patch: Int, suffix: Option[String] = None) extends Ordered[Version] derives ReadWriter:
    def compare(that: Version): Int =
      Ordering[(Int, Int, Int, Option[String])].compare((this.major, this.minor, this.patch, this.suffix), (that.major, that.minor, that.patch, that.suffix))
    override def toString: String = s"$major.$minor.$patch${suffix.fold("")(s => s"-$s")}"
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
      else throw new IllegalArgumentException("Versions are the same: " + oldVersion + " -> " + newVersion)
    
    /**
      * Parses a version string into a Version object.
      * Format: major.minor[.patch][-suffix]
      * Lacking patch is treated as 0
      */
    def parse(s: String): Option[Version] = 
      val regex = """(\d+)\.(\d+)(\.\d+)?(-[a-zA-Z\d\.]+)?""".r
      s match
        case regex(major, minor, patch, suffix) => Some(Version(major.toInt, minor.toInt, Option(patch).map(_.drop(1).toInt).getOrElse(0), Option(suffix).map(_.drop(1))))
        case _ => None


  sealed abstract class VersionDiff(val order: Int) extends Ordered[VersionDiff]:
    def compare(that: VersionDiff): Int = order compare that.order
  case object PatchUpdate extends VersionDiff(0)
  case object MinorUpdate extends VersionDiff(1)
  case object MajorUpdate extends VersionDiff(2)

  object VersionString:
    def unapply(s: String): Option[Version] = Version.parse(s)

  case class Dep(id: String, version: Version, deps: List[Dep]) derives ReadWriter:
    override def toString: String = s"$id:$version"
    def toMdTree: String = Dep.toMdTreeRec(List((this, 0)), Set.empty, "")

  object Dep:
    def resolve(org: String, module: String, crossVersion: String, version: Version): Dep =
      val dep = Dependency(Module(Organization(org), ModuleName(module + "_" + crossVersion)), version.toString)
      val resolution = Resolve()
          .addDependencies(dep)
          .run()
      
      val head = DependencyTree(resolution).head
      makeDepTree(head)

    def makeDepTree(tree: DependencyTree): Dep =
      val dep = tree.dependency
      val depId = s"${dep.module.organization.value}:${dep.module.name.value}"
      val versionParsed = Version.parse(dep.version)
      versionParsed match
        case Some(version) => Dep(dep.module.toString(), version, tree.children.map(makeDepTree).toList)
        case None => throw new Exception(s"Could not parse version from $depId:${dep.version}")
      
    @tailrec
    private def toMdTreeRec(queue: List[(Dep, Int)], visited: Set[Dep], resultAcc: String): String = 
      queue match
        case Nil => resultAcc
        case (head, depth) :: tail if visited.contains(head) => 
          toMdTreeRec(tail, visited, resultAcc + "\n" + ("  " * depth) + s" - ${head.id}:${head.version} (already listed)")
        case (head, depth) :: tail =>
          val children = head.deps.map((_, depth + 1))
          val updatedResult = resultAcc + "\n" + ("  " * depth) + s" - ${head.id}:${head.version}"
          toMdTreeRec(children ++ tail, visited + head, updatedResult)
