//> using toolkit default
//> using platform scala-js

import scala.concurrent.ExecutionContext.Implicits.global

import sttp.client4.quick.*

val request = quickRequest
  .post(uri"https://example.com/")
  .body("Lorem ipsum")

for response <- request.send() do
  val firstLines = response.body.linesIterator.take(4).mkString("\n")
  println(firstLines)
  //$ <!doctype html>
  //$ <html>
  //$ <head>
  //$ <title>Example Domain</title>