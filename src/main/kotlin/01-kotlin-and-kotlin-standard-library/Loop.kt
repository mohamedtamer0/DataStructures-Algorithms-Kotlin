package `01-kotlin-and-kotlin-standard-library`

fun main() {
    for (i in 1..3) {
        println(i)
    }


    val collection = arrayOf(1, 2, 3)
    for (item in collection) println(item)

    var x = 10
    while (x > 0) {
        x--
    }

    x = 10
    do {
        x--
    } while (x > 0)


    x = 10
    while (x > 0) {
        x++
    }
    println("The light at the end of the tunnel!")

}