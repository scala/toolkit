//> using lib "com.softwaremill.sttp.client3::core:3.8.5"
//> using lib "com.lihaoyi::upickle:2.0.0"
//> using lib "com.lihaoyi::os-lib:0.9.0"
//> using lib "org.scalameta::munit::1.0.0-M7"

import sttp.client3._
import sys.error
import git.Repo
import git.Commit
import git.Contributor
import java.nio.file.Path

@main
def main(operation: String, owner: String, repoName: String) =
    val repo = Repo(owner, repoName)
    operation match
        case "contributors" => repo.getContributors()
                                   .sortWith(_.commits > _.commits)
                                   .foreach(c => println(s"$c.author,$c.count"))
        case "commits" => repo.getCommits()
                              .foreach(commit => println(s"$commit.author,$commit.date"))
        case "lines" => repo.lineCountPerLanguage()
                            .toSeq
                            .sortWith(_._2 > _._2)
                            .foreach((lang, lines) => println(s"$lang,$lines"))
        case "issues" => repo.getOpenIssuesWithoutAnswers()
                             .foreach(println)