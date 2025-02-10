//> using toolkit default
//> using platform scala-js

import scala.concurrent.ExecutionContext.Implicits.global

import sttp.client4.*

val backend = DefaultFutureBackend()
val request = basicRequest
  .post(uri"https://example.com/")
  .body("Lorem ipsum")

for response <- backend.send(request) do
  println(response.code)
  //$ 403
