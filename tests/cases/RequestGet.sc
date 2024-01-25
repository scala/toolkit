import sttp.client4.quick.*

val request = quickRequest.get(uri"https://httpbin.org/get")
val response = request.send()

val urlLine = response.body.linesIterator.find(_.contains("url")).get
println(urlLine) //> "url": "https://httpbin.org/get"