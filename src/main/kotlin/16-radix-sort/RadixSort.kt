package `16-radix-sort`


fun MutableList<Int>.radixSort() {
    val base = 10
    var done = false
    var digits = 1
    while (!done) {
        done = true
        // 1
        val buckets = MutableList<MutableList<Int>>(base) { mutableListOf() }
        this.forEach { number ->
            val remainingPart = number / digits
            val digit = remainingPart % base
            buckets[digit].add(number)

            if (remainingPart > 0) {
                done = false
            }
        }
        digits *= base
        this.clear()
        this.addAll(buckets.flatten())
    }
}
