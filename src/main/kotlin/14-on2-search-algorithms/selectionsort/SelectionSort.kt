package `14-on2-search-algorithms`.selectionsort

import swapAt

fun <T : Comparable<T>> MutableList<T>.selectionSort(showPasses: Boolean = false) {
    if (this.size < 2) return
    //1
    for (current in 0 until this.lastIndex) {
        var lowest = current
        //2
        for (other in (current + 1) until this.size) {
            if (this[other] < this[lowest]) {
                lowest = other
            }
        }
        //3
        if (lowest != current) {
            this.swapAt(lowest, current)
        }
        //4
        if (showPasses) println(this)
    }
}