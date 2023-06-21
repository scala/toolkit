import Dependencies.Version
import Dependencies.VersionString
object Config:
    val organization = "org.scala-lang"
    val name = "toolkit"
    val crossVersions = List("3", "2.13")
    private val releaseVersionString = "0.2.0"
    private val developmentVersionString = "0.3.0"

    val releaseVersion = Version.parse(releaseVersionString).getOrElse(throw IllegalArgumentException("Invalid release version"))
    val developmentVersion = Version.parse(developmentVersionString).getOrElse(throw IllegalArgumentException("Invalid development version"))
