//> using dep com.softwaremill.sttp.client4::core::4.0.0-M14
//> using platform native

import sttp.client4.quick.*

val request = quickRequest.get(uri"https://httpbin.io/get")
val response = request.send()

val urlLine = response.body.linesIterator.find(_.contains("url")).get
println(urlLine) //$ "url": "https://httpbin.io/get"
