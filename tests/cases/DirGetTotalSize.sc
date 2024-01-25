val totalSize = os.walk.stream.attrs(os.pwd / "tests" / "cases" / "resources")
 .collect { case (path, attrs) if attrs.isFile => attrs.size }
 .sum

println(totalSize) //> 24
