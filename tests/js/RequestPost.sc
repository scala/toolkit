//> using toolkit default
//> using platform scala-js

import scala.concurrent.ExecutionContext.Implicits.global

import sttp.client4.quick.*

val request = quickRequest
  .post(uri"https://example.com/")
  .body("Lorem ipsum")

for response <- request.send() do
  println(response.body.linesIterator.size)
  //$ 0
