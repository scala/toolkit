//> using toolkit latest

import upickle.default._

case class PetOwner(name: String, pet: String) derives ReadWriter
val petOwner = PetOwner("Peter", "Toolkitty")
val json = write(petOwner)

println(json)
