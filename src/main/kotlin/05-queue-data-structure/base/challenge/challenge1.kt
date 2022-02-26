package `05-queue-data-structure`.base.challenge

import `05-queue-data-structure`.base.Queue
import `05-queue-data-structure`.base.list.ArrayListQueue
import example

fun <T : Any> Queue<T>.nextPlayer(): T? {
    //1
    val person = this.dequeue() ?: return null
    //2
    this.enqueue(person)
    //3
    return person
}

fun main() {
    "boardGame manager with Queue" example {
        val queue = ArrayListQueue<String>().apply {
            enqueue("Vincent")
            enqueue("Remel")
            enqueue("Lukiih")
            enqueue("Allison")
        }
        println(queue)
        println("===== boardGame =======")
        queue.nextPlayer()
        println(queue)
        queue.nextPlayer()
        println(queue)
        queue.nextPlayer()
        println(queue)
        queue.nextPlayer()
        println(queue)
    }
}