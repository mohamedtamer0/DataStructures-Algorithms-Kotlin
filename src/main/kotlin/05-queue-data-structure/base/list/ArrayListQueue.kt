package `05-queue-data-structure`.base.list

import `05-queue-data-structure`.base.Queue

class ArrayListQueue<T : Any> : Queue<T> {

    private val list = arrayListOf<T>()
    override fun enqueue(element: T): Boolean {
        list.add(element)
        return true
    }

    override fun dequeue(): T? {
        return if (isEmpty) null else list.removeAt(0)
    }

    override val count: Int
        get() = list.size

    override fun peek(): T? {
        return list.getOrNull(0)
    }

    override fun toString(): String {
        return list.toString()
    }
}