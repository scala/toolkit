package git

import sys.error
import sttp.client3._
import sttp.model._
import os.Path

import scala.collection.mutable.ArrayBuffer
import scala.util.Try
import scala.util.Success

import git.Lang.*
import git.Commit
import git.Contributor

class Repo(val owner: String, val repoName: String):
    lazy val localRepo = cloneRepo()
    val client = SimpleHttpClient()
    
    def getCommits(page: Int = 1): ArrayBuffer[Commit] = 
        val request = basicRequest
            .header("Accept", "application/vnd.github+json")
            .get(uri"https://api.github.com/repos/$owner/$repoName/commits?per_page=100&page=$page")
    
        val response = client.send(request)
        val json = response.body match
            case Right(content) => content
            case Left(value) => error(value)

        val commits = Commit.commitsFromJson(json)
        if (isLast(response)) commits else commits ++= getCommits(page + 1)

    def getContributors(): List[Contributor] = 
        getCommits()
            .groupBy(_.author)
            .mapValues(seq => seq.length)
            .map((author, commits) => Contributor(author, commits))
            .toList
    
    def getOpenIssuesWithoutAnswers(page: Int = 1): ArrayBuffer[Uri] = 
        val request = basicRequest
            .header("Accept", "application/vnd.github+json")
            .get(uri"https://api.github.com/repos/$owner/$repoName/issues?per_page=100&page=$page")

        val response = client.send(request)
        val json = response.body match
            case Right(content) => content
            case Left(value) => error(value)

        val issues = for issue <- ujson.read(json).arr
        if issue("state").str == "open"
        if Try(issue("pull_request")).isFailure
        if hasNoComments(issue("comments_url").str)
        yield uri"${issue("html_url").str}"

        if (isLast(response)) issues else issues ++= getOpenIssuesWithoutAnswers(page + 1)

    def lineCountPerLanguage(): Map[Lang, Int] = 
        os.walk(localRepo, skip = _.last.equals(".git"))
            .filter(os.isFile)
            .map(path => Lang.fromExtension(path.ext) -> path)
            .map((lang, path) => (lang, getLineCount(path)))
            .groupBy(_._1)
            .mapValues(seq => seq.map(_._2).reduce(_ + _))
            .toMap

    private def cloneRepo(): Path = 
        val tmpDir = os.temp.dir()
        val address = uri"https://github.com/$owner/$repoName.git"
        os.proc("git", "clone", address.toString)
            .call(cwd = tmpDir)
        tmpDir

    private def getLineCount(path: Path): Int =
        Try(os.read.lines(path).filter(_.nonEmpty).size) match
            case Success(value) => value
            case _ => 0

    private def hasNoComments(uri: String): Boolean = 
        val request = basicRequest
            .header("Accept", "application/vnd.github+json")
            .get(uri"$uri")
        
        val response = client.send(request)
        val json = response.body match
            case Right(content) => content
            case Left(value) => error(value)
        
        ujson.read(json).arr.isEmpty

    private def isLast(response: Response[Either[String, String]]) =
        response.header(HeaderNames.Link) match
            case Some(value) => !value.contains("rel=\"next\"")
            case None => true

