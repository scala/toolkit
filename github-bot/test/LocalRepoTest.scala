import munit._
import git._
import git.Lang.*

class LocalRepoTest extends munit.FunSuite:
    test("getLineCount") {
        // given
        val repo = LocalRepo("octocat", "Spoon-Knife")
        // when
        val langObtained = repo.getLineCount()
        // then
        val langExpected = Map(
            Markdown -> 5,
            HTML -> 15,
            CSS -> 15
        )
        assertEquals(langObtained, langExpected)
    }

    test("clone") {
        // given cloned repository
        val tmpDir = os.temp.dir()
        val repo = LocalRepo("octocat", "Spoon-Knife", tmpDir)
        // when checking if its really a git repository
        val exitCode = os.proc("git", "status").call(cwd = tmpDir/"Spoon-Knife").exitCode
        // then command completes successfully
        assert(exitCode == 0)
    }