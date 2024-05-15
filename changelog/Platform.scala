enum Platform:
  case Jvm, Js, Native

  def scalaCliOptions: Seq[String] = this match
    case Jvm => Seq.empty
    case Js => Seq("--js")
    case Native => Seq("--native")

  def binarySuffix: String = this match
    case Jvm => ""
    case Js => "_sjs1"
    case Native => "_native0.5"
