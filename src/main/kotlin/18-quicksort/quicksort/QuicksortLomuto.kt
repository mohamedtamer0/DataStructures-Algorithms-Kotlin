package `18-quicksort`.quicksort

import swapAt


fun <T : Comparable<T>> MutableList<T>.quicksortLomuto(
    low: Int,
    high: Int
): Int {
    val pivot = this[high]//1

    var i = low //2
    for (j in low until high) { //3
        if (this[j] <= pivot) {//4
            this.swapAt(i, j) //5
            i += 1
        }
    }
    this.swapAt(i, high) //6
    return i //7
}