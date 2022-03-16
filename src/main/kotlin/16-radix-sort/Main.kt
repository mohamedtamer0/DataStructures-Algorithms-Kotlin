package `16-radix-sort`

import example

fun main() {
    "radix sort" example {
        val list = arrayListOf(88, 410, 1772, 20)
        println("Original: $list")
        list.radixSort()
        println("Radix sorted: $list")
    }
}