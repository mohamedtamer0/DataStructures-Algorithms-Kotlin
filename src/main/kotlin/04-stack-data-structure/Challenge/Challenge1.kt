package `04-stack-data-structure`.Challenge

import `03-linked-list`.LinkedList
import `04-stack-data-structure`.StackImpl

/*:
 # Stack Challenges
 ## Challenge 1:
    Print a linked list in reverse without using recursion.
    Given a linked list, print the nodes in reverse order.
    You should not use recursion to solve this problem.
 */

fun <T : Any> LinkedList<T>.printInReverse() {
    val stack = StackImpl<T>()
    for (node in this) {
        stack.push(node)
    }

    var node = stack.pop()
    while (node != null) {
        println(node)
        node = stack.pop()
    }
}