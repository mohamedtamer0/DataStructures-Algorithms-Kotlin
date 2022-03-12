package `13-priority-queue`

import example

fun main() {

    "max priority queue" example {
        val priorityQueue = ComparablePriorityQueueImpl<Int>()
        arrayListOf(1, 12, 3, 4, 1, 6, 8, 7).forEach {
            priorityQueue.enqueue(it)
        }
        while (!priorityQueue.isEmpty) {
            println(priorityQueue.dequeue())
        }
    }


    "min priority queue" example {
        val stringLengthComparator = Comparator<String> { o1, o2 ->
            val length1 = o1?.length ?: -1
            val length2 = o2?.length ?: -1
            length1 - length2
        }
        val priorityQueue = ComparatorPriorityQueueImpl(stringLengthComparator)
        arrayListOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine").forEach {
            priorityQueue.enqueue(it)
        }
        while (!priorityQueue.isEmpty) {
            println(priorityQueue.dequeue())
        }
    }
}

