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


}