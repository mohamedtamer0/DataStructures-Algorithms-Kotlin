package `02-complexity`

/*
fun linearContains(value: Int, numbers: List<Int>): Boolean {
    for (element in numbers) {
        if (element == value) {
            return true
        }
    }
    return false
}
 */



// O(log n)
fun pseudoBinaryContains(value: Int, numbers: List<Int>): Boolean {
    if (numbers.isEmpty()) return false
    val midIndex = numbers.size / 2
    if (value <= numbers[midIndex]) {
        for (index in 0..midIndex) {
            if (numbers[index] == value) {
                return true
            }
        }
    } else {
        for (index in midIndex until numbers.size) {
            if (numbers[index] == value) {
                return true
            }
        }
    }
    return false
}


fun main() {
    /*
    val numbers = listOf(1, 3, 56, 66, 68, 80, 99, 105, 450)
    println(linearContains(3, numbers))
     */

    val numbers = listOf(1, 3, 56, 66, 68, 80, 99, 105, 450)
    println(pseudoBinaryContains(22, numbers))


}