package `05-queue-data-structure`.base

import `05-queue-data-structure`.base.linkedlist.LinkedListQueue
import `05-queue-data-structure`.base.list.ArrayListQueue
import `05-queue-data-structure`.base.ringbuffer.RingBufferQueue
import example

fun main() {
    "Queue with ArrayList" example {
        val queue = ArrayListQueue<String>().apply {
            enqueue("Ray")
            enqueue("Brian")
            enqueue("Eric")
        }
        println(queue)
        queue.dequeue()
        println(queue)
        println("Next up: ${queue.peek()}")
    }


    "Queue with Linked List" example {
        val queue = LinkedListQueue<String>().apply {
            enqueue("Ray")
            enqueue("Brian")
            enqueue("Eric")
        }
        println(queue)
        queue.dequeue()
        println(queue)
        println("Next up: ${queue.peek()}")
    }


    "Queue with Ring Buffer" example {
        val queue = RingBufferQueue<String>(10).apply {
            enqueue("Ray")
            enqueue("Brian")
            enqueue("Eric")
        }
        println(queue)
        queue.dequeue()
        println(queue)
        println("Next up: ${queue.peek()}")
    }


}