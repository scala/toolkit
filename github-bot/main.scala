//> using lib "com.softwaremill.sttp.client3::core:3.8.5"
//> using lib "com.lihaoyi::upickle:2.0.0"
//> using lib "com.lihaoyi::os-lib:0.9.0"
//> using lib "org.scalameta::munit::1.0.0-M7"

import sttp.client3._
import sys.error
import git.LocalRepo
import git.RemoteRepo
import java.nio.file.Path

@main
def main(operation: String, owner: String, repoName: String, other: String*) =
    operation match
        case "contributors" => RemoteRepo(owner, repoName)
                                            .getContributors(other(0))
                                            .toSeq
                                            .sortWith(_._2 > _._2)
                                            .foreach((author, count) => println(s"$author,$count"))
        case "commits" => RemoteRepo(owner, repoName)
                                            .getCommits(other(0))
                                            .foreach((author, sha, date) => println(s"$author,$date"))
        case "lines" => LocalRepo(owner, repoName)
                                            .getLineCount()
                                            .toSeq
                                            .sortWith(_._2 > _._2)
                                            .foreach((lang, lines) => println(s"$lang,$lines"))
        case "clone" => LocalRepo(owner, repoName, os.Path(Path.of(other(0)).toAbsolutePath()))
        case "issues" => RemoteRepo(owner, repoName)
                            .getOpenIssuesWithoutAnswers(other(0))
                            .foreach(println)