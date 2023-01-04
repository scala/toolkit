import munit._
import git._
import scala.collection.mutable.ArrayBuffer

class RemoteRepoTest extends munit.FunSuite:
    val token = sys.env.getOrElse("GITHUB_TOKEN", throw RuntimeException("GITHUB_TOKEN enviroment variable not set"))

    test("getCommits") {
        // given
        val repo = RemoteRepo("octocat", "Spoon-Knife")
        // when
        val commitsObtained = repo.getCommits("$token")
        // then
        val commitsExpected = ArrayBuffer(
            ("octocat", "d0dd1f61b33d64e29d8bc1372a94ef6a2fee76a9", "2014-02-12T23:20:44Z"),
            ("octocat", "bb4cc8d3b2e14b3af5df699876dd4ff3acd00b7f", "2014-02-04T22:38:36Z"),
            ("octocat", "a30c19e3f13765a3b48829788bc1cb8b4e95cee4", "2014-02-04T22:38:24Z")
        )
        assertEquals(commitsObtained, commitsExpected)
    }

    test("getContributors") {
        // given
        val repo = RemoteRepo("octocat", "Spoon-Knife")
        // when
        val contributorsObtained = repo.getContributors("$token")
        // then
        val contributorsExpected = Map(
            "octocat" -> 3
        )
        assertEquals(contributorsObtained, contributorsExpected)
    }

    test("issues") {
        fail("not impemented")
    }