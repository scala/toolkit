//> using toolkit default

import sttp.client4.quick.*

val response = quickRequest
  .post(uri"https://example.com/")
  .body("Lorem ipsum")
  .send()

val firstLines = response.body.linesIterator.take(4).mkString("\n")
println(firstLines)
//$ <!doctype html>
//$ <html>
//$ <head>
//$ <title>Example Domain</title>
