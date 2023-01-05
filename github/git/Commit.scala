package git

import scala.collection.mutable.ArrayBuffer
import scala.util.Try

case class Commit(author: String, sha: String, date: String)
object Commit:
    def commitsFromJson(json: String): ArrayBuffer[Commit] =
        for commit <- ujson.read(json).arr 
        yield
            val author = Try(commit("author")("login").str)
                        .orElse(Try(commit("commit")("author")("name").str))
                        .getOrElse("Unknown")
            val sha = commit("sha").str
            val date = Try(commit("commit")("author")("date").str).getOrElse("")
                Commit(author, sha, date)
