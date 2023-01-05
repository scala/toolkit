import munit._
import git._
import git.Lang.*

class RepoTest extends munit.FunSuite:
    test("getCommits") {
        // given
        val repo = Repo("octocat", "Spoon-Knife")
        // when
        val commitsObtained = repo.getCommits()
        // then
        val commitsExpected = List(
            Commit("octocat", "d0dd1f61b33d64e29d8bc1372a94ef6a2fee76a9", "2014-02-12T23:20:44Z"),
            Commit("octocat", "bb4cc8d3b2e14b3af5df699876dd4ff3acd00b7f", "2014-02-04T22:38:36Z"),
            Commit("octocat", "a30c19e3f13765a3b48829788bc1cb8b4e95cee4", "2014-02-04T22:38:24Z")
        )
        assertEquals(commitsObtained, commitsExpected)
    }

    test("getContributors") {
        // given
        val repo = Repo("octocat", "Spoon-Knife")
        // when
        val contributorsObtained = repo.getContributors()
        // then
        val contributorsExpected = List(
            Contributor("octocat", 3)
        )
        assertEquals(contributorsObtained, contributorsExpected)
    }

    test("getLineCount") {
        // given
        val repo = Repo("octocat", "Spoon-Knife")
        // when
        val langObtained = repo.lineCountPerLanguage()
        // then
        val langExpected = Map(
            Markdown -> 5,
            HTML -> 15,
            CSS -> 15
        )
        assertEquals(langObtained, langExpected)
    }

    test("issues") {
        fail("not impemented")
    }

