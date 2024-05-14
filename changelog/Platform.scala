enum Platform:
  case Jvm, Js, Native

  def scalaCliOptions: Seq[String] = this match
    case Jvm => Seq.empty
    case Js => Seq("--js")
    case Native => Seq("--native", "--native-version", "0.4.17")

  def binarySuffix: String = this match
    case Jvm => ""
    case Js => "_sjs1"
    case Native => "_native0.4"
