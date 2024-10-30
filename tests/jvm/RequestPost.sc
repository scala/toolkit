//> using toolkit default

import sttp.client4.quick.*

val response = quickRequest
  .post(uri"https://example.com/")
  .body("Lorem ipsum")
  .send()

println(response.body.linesIterator.size)
//$ 0
