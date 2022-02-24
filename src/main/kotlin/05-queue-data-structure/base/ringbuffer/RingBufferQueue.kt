package `05-queue-data-structure`.base.ringbuffer

import `05-queue-data-structure`.base.Queue

class RingBufferQueue<T : Any>(size: Int) : Queue<T> {
    private val ringBuffer: RingBuffer<T> = RingBuffer(size)

    override fun enqueue(element: T): Boolean {
        return ringBuffer.write(element)
    }

    override fun dequeue(): T? {
        return if (isEmpty) null else ringBuffer.read()
    }

    override val count: Int
        get() = ringBuffer.count

    override fun peek(): T? {
        return ringBuffer.first
    }

    override fun toString(): String {
        return ringBuffer.toString()
    }
}