package `03-linked-list`.Challenge

import `03-linked-list`.LinkedList
import `03-linked-list`.Node
import example

/*
Create a function that takes two sorted linked lists and merges them into a single
sorted linked list
Your goal is to return a new linked list that contains the nodes from two lists in
sorted order. You may assume they are both sorted in ascending order. For example:
// list1
1 -> 4 -> 10 -> 11
// list2
-1 -> 2 -> 3 -> 6
// merged list
-1 -> 1 -> 2 -> 3 -> 4 -> 6 -> 10 -> 11
 */

fun <T : Comparable<T>> LinkedList<T>.mergeSorted(
    otherList: LinkedList<T>
): LinkedList<T> {
    if (this.isEmpty()) return otherList
    if (otherList.isEmpty()) return this
    val result = LinkedList<T>()

    var left = nodeAt(0)
    var right = otherList.nodeAt(0)

    while (left != null && right != null) {
        if (left.value < right.value) {
            left = append(result, left)
        } else {
            right = append(result, right)
        }
    }

    while (left != null) {
        left = append(result, left)
    }

    while (right != null) {
        right = append(result, right)
    }

    return result
}

private fun <T : Comparable<T>> append(
    result: LinkedList<T>,
    node: Node<T>
): Node<T>? {
    result.append(node.value)
    return node.next
}


fun main() {
    "merge lists" example {
        val list = LinkedList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        list.add(4)
        list.add(5)
        val other = LinkedList<Int>()
        other.add(-1)
        other.add(0)
        other.add(2)
        other.add(2)
        other.add(7)
        println("Left: $list")
        println("Right: $other")
        println("Merged: ${list.mergeSorted(other)}")
    }
}