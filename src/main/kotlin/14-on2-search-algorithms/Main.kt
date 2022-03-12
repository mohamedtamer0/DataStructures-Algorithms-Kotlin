package `14-on2-search-algorithms`

import `14-on2-search-algorithms`.bubblesort.bubbleSort
import example


fun main() {

    "bubble sort" example {
        val list = arrayListOf(9, 4, 10, 3)
        println("Original: $list")
        list.bubbleSort(true)
        println("Bubble sorted: $list")
    }


}