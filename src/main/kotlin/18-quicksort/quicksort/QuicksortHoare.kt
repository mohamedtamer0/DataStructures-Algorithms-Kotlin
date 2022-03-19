package `18-quicksort`.quicksort

import swapAt


fun <T : Comparable<T>> MutableList<T>.quicksortHoare(low: Int, high: Int) {
    if (low < high) {
        val p = this.partitionHoare(low, high)
        this.quicksortHoare(low, p)
        this.quicksortHoare(p + 1, high)
    }
}

fun <T : Comparable<T>> MutableList<T>.partitionHoare(low: Int, high: Int): Int {
    val pivot = this[low] // 1
    var i = low - 1 // 2
    var j = high + 1
    while (true) {
        do { // 3
            j -= 1
        } while (this[j] > pivot)
        do { // 4
            i += 1
        } while (this[i] < pivot)
        if (i < j) { // 5
            this.swapAt(i, j)
        } else {
            return j // 6
        }
    }
}