//> using toolkit default

import sttp.client4.quick.*

val response = basicRequest
  .post(uri"https://example.com/")
  .body("Lorem ipsum")
  .send()

println(response.code)
//$ 403
