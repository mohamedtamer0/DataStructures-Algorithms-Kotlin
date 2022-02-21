package `03-linked-list`.Challenge

import `03-linked-list`.LinkedList
import `03-linked-list`.Node
import example

/*
Challenge 1: Reverse a linked list
Create an extension function that prints out the elements of a linked list in reverse
order. Given a linked list, print the nodes in reverse order. For example:
1 -> 2 -> 3
// should print out the following:
3
2
1
 */
//Solution:
fun <T : Any> LinkedList<T>.printInReverse() {
    this.nodeAt(0)?.printInReverse()
}

fun <T : Any> Node<T>.printInReverse() {
    this.next?.printInReverse()
    if (this.next != null) {
        print(" <- ")
    }
    print(this.value.toString())
}

fun main() {
    "print in reverse" example {
        val list = LinkedList<Int>()
        list.add(3)
        list.add(2)
        list.add(1)
        list.add(4)
        list.add(5)
        println(list)
        list.printInReverse()
    }
}