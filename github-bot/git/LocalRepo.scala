package git

import scala.util.control.Exception.*
import scala.io.Codec
import sttp.model.Uri
import sttp.model.Uri.UriContext

import git.Lang.*
import os.Path

class LocalRepo private(val address: Uri, private val dir: os.Path):
    def getLineCount(): Map[Lang, Int] = 
        os.walk(dir, skip = _.last.equals(".git"))
            .filter(os.isFile)
            .map(path => path.ext match
                case "sc" => Scala -> path
                case "scala" => Scala -> path
                case "js" => JavaScript -> path
                case "ts" => TypeScript -> path
                case "py" => Python -> path
                case "c" => C -> path
                case "h" => C -> path
                case "go" => Go -> path
                case "yml" => Yaml -> path
                case "adoc" => AsciiDoc -> path
                case "md" => Markdown -> path
                case "sh" => Shell -> path
                case "html" => HTML -> path
                case "css" => CSS -> path
                case _ => Other -> path
            )
            .map((lang, path) => (lang,
                allCatch.opt(os.read.lines(path).filter(_.nonEmpty).size) match
                    case Some(lines) => lines
                    case None => 0
            ))
            .groupBy(_._1)
            .mapValues(seq => seq.map(_._2).reduce(_ + _))
            .toMap

object LocalRepo:
    def apply(owner: String, repoName: String): LocalRepo = 
        val tmpDir = os.temp.dir()
        apply(owner, repoName, tmpDir)

        
    def apply(owner: String, repoName: String, dir: Path): LocalRepo = 
        val address = uri"https://github.com/$owner/$repoName.git"
        os.makeDir.all(dir)
        os.proc("git", "clone", address.toString)
            .call(cwd = dir)
        new LocalRepo(address, dir)