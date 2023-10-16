//> using toolkit latest
//> using dep org.scala-lang::toolkit-test:latest.stable
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ TODO: remove when scala-cli supports toolkit-test

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
