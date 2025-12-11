//> using toolkit default

import sttp.client4.quick.*

val request = quickRequest.get(uri"https://httpbin.io/get")
val response = request.send()

println(response.body)

