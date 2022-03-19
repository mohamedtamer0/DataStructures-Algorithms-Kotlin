package `18-quicksort`.quicksort

import swapAt

fun <T : Comparable<T>> MutableList<T>.quickSortMedian(low: Int, high: Int) {
    if (low < high) {
        val pivotIndex = medianOfThree(low, high)
        this.swapAt(pivotIndex, high)
        val pivot = quicksortLomuto(low, high)
        this.quicksortLomuto(low, pivot - 1)
        this.quicksortLomuto(pivot + 1, high)
    }
}

fun <T : Comparable<T>> MutableList<T>.medianOfThree(low: Int, high: Int): Int {
    val center = (low + high) / 2
    if (this[low] > this[center]) {
        this.swapAt(low, center)
    }
    if (this[low] > this[high]) {
        this.swapAt(low, high)
    }
    if (this[center] > this[high]) {
        this.swapAt(center, high)
    }
    return center
}