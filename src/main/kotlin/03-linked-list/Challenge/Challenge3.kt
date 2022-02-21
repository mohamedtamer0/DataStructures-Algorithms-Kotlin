package `03-linked-list`.Challenge

import `03-linked-list`.LinkedList
import `03-linked-list`.Node
import example

/*
To reverse a list is to manipulate the nodes so that the nodes of the list are linked in
the opposite direction. For example:
// before
1 -> 2 -> 3
// after
3 -> 2 -> 1
 */



fun <T : Any> addInReverse(list: LinkedList<T>, node: Node<T>) {
    val next = node.next
    if (next != null) {
        addInReverse(list, next)
    }
    list.append(node.value)
}


fun <T : Any> LinkedList<T>.reversed(): LinkedList<T> {
    val result = LinkedList<T>()
    val head = this.nodeAt(0)
    if (head != null) {
        addInReverse(result, head)
    }
    return result
}

fun main() {
    "reverse list" example {
        val list = LinkedList<Int>()
        list.add(3)
        list.add(2)
        list.add(1)
        list.add(4)
        list.add(5)
        println("Original: $list")
        println("Reversed: ${list.reversed()}")
    }
}