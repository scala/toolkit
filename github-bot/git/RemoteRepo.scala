package git

import sys.error
import sttp.client3._
import sttp.model._
import upickle.default._
import scala.collection.mutable.ArrayBuffer
import scala.util.Try


class RemoteRepo(val owner: String, val repoName: String):
    val client = SimpleHttpClient()

    private def isLast(response: Response[Either[String, String]]) =
        response.header(HeaderNames.Link) match
            case Some(value) => !value.contains("rel=\"next\"")
            case None => true


    private def commitsFromJson(json: String) =
        for commit <- ujson.read(json).arr 
            yield 
                (
                    Try(commit("author")("login").str)
                        .orElse(Try(commit("commit")("author")("name").str))
                        .getOrElse("Unknown"),
                    commit("sha").str,
                    Try(commit("commit")("author")("date").str)
                        .getOrElse("")
                )

    
    def getCommits(token: String, page: Int = 1): ArrayBuffer[(String, String, String)] = 
        val request = basicRequest
            .header("Accept", "application/vnd.github+json")
            .header("Authorization", "${token}")
            .get(uri"https://api.github.com/repos/$owner/$repoName/commits?per_page=100&page=$page")
    
        val response = client.send(request)
        val json = response.body match
            case Right(content) => content
            case Left(value) => error(value)

        val commits = commitsFromJson(json)
        if (isLast(response)) commits else commits ++= getCommits(token, page + 1)


    def getContributors(token: String): Map[String, Int] = 
        getCommits(token)
            .groupBy(_._1)
            .mapValues(seq => seq.length)
            .toMap


    def hasNoComments(uri: String, token: String): Boolean = 
        val request = basicRequest
            .header("Accept", "application/vnd.github+json")
            .header("Authorization", "${token}")
            .get(uri"$uri")
        
        val response = client.send(request)
        val json = response.body match
            case Right(content) => content
            case Left(value) => error(value)
        
        ujson.read(json).arr.isEmpty
        


    def getOpenIssuesWithoutAnswers(token: String, page: Int = 1): ArrayBuffer[Uri] = 
        val request = basicRequest
            .header("Accept", "application/vnd.github+json")
            .header("Authorization", "${token}")
            .get(uri"https://api.github.com/repos/$owner/$repoName/issues?per_page=100&page=$page")

        val response = client.send(request)
        val json = response.body match
            case Right(content) => content
            case Left(value) => error(value)

        val issues = for issue <- ujson.read(json).arr
        if issue("state").str == "open"
        if Try(issue("pull_request")).isFailure
        if hasNoComments(issue("comments_url").str, token)
        yield uri"${issue("html_url").str}"

        if (isLast(response)) issues else issues ++= getOpenIssuesWithoutAnswers(token, page + 1)