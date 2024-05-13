import Dependencies.Version
import scala.util.Properties

case class Config(organization: String, outputDir: os.Path, releaseVersion: Version, developmentVersion: Version)

object Config:
  def loadFromEnv: Config =
    val organization = Properties.envOrElse("TOOLKIT_ORG", "org.scala-lang")
    val outputDir = Properties.envOrNone("CHANGELOG_DIR").map(os.Path(_)).getOrElse(os.pwd / "changelog")
    val releaseVersion = Version.parse(Properties.envOrElse("TOOLKIT_VERSION_RELEASE", "0.2.0"))
    val developmentVersion = Version.parse(Properties.envOrElse("TOOLKIT_VERSION_DEVELOPMENT", "0.2.1"))
    Config(organization, outputDir, releaseVersion, developmentVersion)
