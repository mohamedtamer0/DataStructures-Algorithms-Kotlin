package `13-priority-queue`

import ComparableHeapImpl
import ComparatorHeapImpl
import Heap
import java.util.*
import `05-queue-data-structure`.base.Queue

abstract class AbstractPriorityQueue<T : Any> : Queue<T> {

    abstract val heap: Heap<T>
        get

    override fun enqueue(element: T): Boolean {
        heap.insert(element)
        return true
    }

    override fun dequeue(): T? = heap.remove()

    override val count: Int
        get() = heap.count

    override fun peek(): T? = heap.peek()

}

class ComparablePriorityQueueImpl<T : Comparable<T>> : AbstractPriorityQueue<T>() {

    override val heap = ComparableHeapImpl<T>()

}

class ComparatorPriorityQueueImpl<T : Any>(private val comparator: Comparator<T>) : AbstractPriorityQueue<T>() {
    override val heap = ComparatorHeapImpl(comparator)

}