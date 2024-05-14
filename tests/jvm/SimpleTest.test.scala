//> using toolkit default

class MathSuite extends munit.FunSuite {
  test("addition") {
    assert(1 + 1 == 2)
  }

  test("read a missing file") {
    val missingFile = os.pwd / "missing.txt"
    intercept[java.nio.file.NoSuchFileException] {
      os.read(missingFile)
    }
  }
}
