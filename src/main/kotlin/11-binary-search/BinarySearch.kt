package `11-binary-search`

fun <T : Comparable<T>> ArrayList<T>.binarySearch(value: T, range: IntRange): Int? {
    //1
    if (range.first > range.last) {
        return null
    }
    //1
    val size = range.last - range.first + 1
    val middle = range.first + size / 2

    return when {
        //3
        this[middle] == value -> middle
        //4
        this[middle] > value -> binarySearch(value, range.first until middle)
        else -> binarySearch(value, (middle + 1)..range.last)
    }
}