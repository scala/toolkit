package git

enum Lang():
  case Scala
  case JavaScript
  case TypeScript
  case Python
  case C
  case Go
  case Yaml
  case AsciiDoc
  case Markdown
  case Shell
  case Other
  case HTML
  case CSS

object Lang:
  def fromExtension(ext: String): Lang =
      ext match
        case "sc" => Scala
        case "scala" => Scala
        case "js" => JavaScript
        case "ts" => TypeScript
        case "py" => Python
        case "c" => C
        case "h" => C
        case "go" => Go
        case "yml" => Yaml
        case "adoc" => AsciiDoc
        case "md" => Markdown
        case "sh" => Shell
        case "html" => HTML
        case "css" => CSS
        case _ => Other
