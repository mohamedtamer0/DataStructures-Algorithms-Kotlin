package `15-merge-sort`


fun <T : Comparable<T>> List<T>.mergeSort(): List<T> {
    if (this.size < 2) return this
    val middle = this.size / 2
    val left = this.subList(0, middle).mergeSort()
    val right = this.subList(middle, this.size).mergeSort()
    return merge(left, right)
}

private fun <T : Comparable<T>> merge(left: List<T>, right: List<T>): List<T> {
    //1
    var leftIndex = 0
    var rightIndex = 0
    //2
    var result = mutableListOf<T>()
    //3
    while (leftIndex < left.size && rightIndex < right.size) {
        val leftElement = left[leftIndex]
        val rightElement = right[rightIndex]
        //4
        if (leftElement < rightElement) {
            result.add(leftElement)
            leftIndex += 1
        } else if (leftElement > rightElement) {
            result.add(rightElement)
            rightIndex += 1
        } else {
            result.add(leftElement)
            leftIndex += 1
            result.add(rightElement)
            rightIndex += 1
        }
    }

    //5
    if (leftIndex < left.size) {
        result.addAll(left.subList(leftIndex, left.size))
    }
    if (rightIndex < right.size) {
        result.addAll(right.subList(rightIndex, right.size))
    }

    return result
}