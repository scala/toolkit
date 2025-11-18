//> using toolkit default

import sttp.client4.quick.*
import scala.util.Try

val response = Try(quickRequest
  .post(uri"https://example.com/")
  .body("Lorem ipsum")
  .send()
)

println(response)
