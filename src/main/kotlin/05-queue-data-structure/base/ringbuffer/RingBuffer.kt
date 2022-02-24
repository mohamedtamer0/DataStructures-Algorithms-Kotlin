package `05-queue-data-structure`.base.ringbuffer

class RingBuffer<T : Any>(private val size: Int) {
    private var array = ArrayList<T?>(size)
    private var readIndex = 0
    private var writeIndex = 0

    private val availableSpaceForReading: Int
        get() = (writeIndex - readIndex)

    val count: Int
        get() = availableSpaceForReading

    val first: T?
        get() = array.getOrNull(readIndex)

    val isEmpty: Boolean
        get() = (count == 0)

    private val availableSpaceForWriting: Int
        get() = (size - availableSpaceForReading)

    val isFull: Boolean
        get() = (availableSpaceForWriting == 0)

    fun write(element: T): Boolean {
        return if (!isFull) {
            if (array.size < size) {
                array.add(element)
            } else {
                array[writeIndex % size] = element
            }
            writeIndex += 1
            true
        } else {
            false
        }
    }

    fun read(): T? {

    }

}