package `01-kotlin-and-kotlin-standard-library`

fun main() {
    val places = listOf("Paris", "London", "Bucharest")

    places[0] // Paris
    places[1] // London
    places[2] // Bucharest


    val mutablePlaces = mutableListOf("Paris", "London", "Bucharest")

    mutablePlaces.add("Budapest")
    println(mutablePlaces) // prints [Paris, London, Bucharest, Budapest]

}