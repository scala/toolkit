//> using toolkit default
//> using platform scala-js

import scala.concurrent.ExecutionContext.Implicits.global
import scala.scalajs.js.timers

import sttp.client4.quick.*

val request = quickRequest.get(uri"https://httpbin.io/get")

for response <- request.send() do
  val urlLine = response.body.linesIterator.find(_.contains("url")).get
  println(urlLine) //$ "url": "https://httpbin.io/get"
