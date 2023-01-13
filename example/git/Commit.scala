package git

import scala.collection.mutable.ArrayBuffer
import scala.util.Try

case class Commit(author: String, sha: String, date: String)
object Commit:
    def commitsFromJson(json: String): List[Commit] =
        for commit <- ujson.read(json).arr.toList
            author = Try(commit("author")("login").str)
                .orElse(Try(commit("commit")("author")("name").str))
                .getOrElse("Unknown")
            sha = commit("sha").str
            date = Try(commit("commit")("author")("date").str).getOrElse("")
        yield
            Commit(author, sha, date)
            