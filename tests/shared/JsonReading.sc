//> using toolkit default

import upickle.default._

case class PetOwner(name: String, pet: String) derives ReadWriter
val jsonString = """{"name": "Peter", "pet": "Toolkitty"}"""
val petOwner: PetOwner = read[PetOwner](jsonString)

println(petOwner)
//$ PetOwner(Peter,Toolkitty)