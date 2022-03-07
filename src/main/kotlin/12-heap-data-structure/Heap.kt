package `12-heap-data-structure`

interface Collection<T : Any> {
    val count: Int

    val isEmpty: Boolean
        get() = count == 0

    fun insert(element: T)

    fun remove(): T?
    fun remove(index: Int): T?

}

interface Heap<T : Any> : Collection<T> {
    fun peek(): T?
}

abstract class AbstractHeap<T : Any>() : Heap<T> {

}