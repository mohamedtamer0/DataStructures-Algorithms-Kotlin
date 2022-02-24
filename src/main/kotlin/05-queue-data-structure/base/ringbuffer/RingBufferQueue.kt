package `05-queue-data-structure`.base.ringbuffer

import `05-queue-data-structure`.base.Queue

class RingBufferQueue<T : Any>(size: Int) : Queue<T> {
    private val ringBuffer: RingBuffer<T> = RingBuffer(size)

    override fun enqueue(element: T): Boolean {
        TODO("Not yet implemented")
    }

    override fun dequeue(): T? {
        TODO("Not yet implemented")
    }

    override val count: Int
        get() = ringBuffer.count

    override fun peek(): T? {
        return ringBuffer.first
    }
}