package `02-complexity`

//O(n^2)
fun multiplicationBoard(size: Int) {
    for (number in 1..size) {
        print(" | ")
        for (otherNumber in 1..size) {
            print("$number X $otherNumber = ${number * otherNumber} | ")
        }
        println()
    }
}

fun main() {
    multiplicationBoard(2)
}
