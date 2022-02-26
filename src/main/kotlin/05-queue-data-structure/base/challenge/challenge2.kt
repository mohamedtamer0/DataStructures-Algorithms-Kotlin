package `05-queue-data-structure`.base.challenge

import `05-queue-data-structure`.base.Queue
import `05-queue-data-structure`.base.doublestack.StackImpl
import `05-queue-data-structure`.base.list.ArrayListQueue
import example

/*:
 # Queue Challenges
 ## Challenge 4:
    Implement a method to reverse the contents of a queue.
    Hint: The `Stack` data structure has been included in the project.
 */


fun <T : Any> Queue<T>.reverse() {
    //1
    val aux = StackImpl<T>()
    //2
    var next = this.dequeue()
    while (next != null) {
        aux.push(next)
        next = this.dequeue()
    }

    //3
    next = aux.pop()
    while (next != null) {
        this.enqueue(next)
        next = aux.pop()
    }
}


fun main() {
    "Reverse queue" example {
        val queue = ArrayListQueue<String>().apply {
            enqueue("1")
            enqueue("21")
            enqueue("18")
            enqueue("42")
        }
        println("before: $queue")
        queue.reverse()
        println("after: $queue")
    }
}