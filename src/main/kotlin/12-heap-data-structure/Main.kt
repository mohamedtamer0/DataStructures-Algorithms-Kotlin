package `12-heap-data-structure`

fun main() {
    val array = arrayListOf(1, 12, 3, 4, 1, 6, 8, 7) // 1
    val inverseComparator = Comparator<Int> { o1, o2 ->  // 2
        o2.compareTo(o1)
    }
    val minHeap = ComparatorHeapImpl.create(array, inverseComparator) // 3
    while (!minHeap.isEmpty) { // 4
        println(minHeap.remove())
    }


}