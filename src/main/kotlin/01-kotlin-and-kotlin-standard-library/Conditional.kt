package `01-kotlin-and-kotlin-standard-library`

fun main() {
    val a = 5
    val b = 12
    
    val maxNumber = if (a > b) {
        a
    } else {
        b
    }

    println(maxNumber)

    val groupSize = 3
    val message = when (groupSize) {
        1 -> "Single"
        2 -> "Pair"
        3 ->  "Trio"
        else -> "This is either nobody or a big crowd"
    }
    println(message)
}
