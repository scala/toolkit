//> using toolkit default

val totalSize = os.walk.stream.attrs(os.pwd / "tests" / "resources")
  .collect { case (path, attrs) if attrs.isFile => attrs.size }
  .sum

println(totalSize) //$ 24
