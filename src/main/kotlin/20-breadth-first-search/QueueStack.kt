package `20-breadth-first-search`

import `05-queue-data-structure`.base.Queue

class QueueStack<T: Any> : Queue<T> {

    private var leftStack = arrayListOf<T>()
    private var rightStack = arrayListOf<T>()

    override fun enqueue(element: T): Boolean {
        rightStack.add(element)
        return true
    }

    override fun dequeue(): T? {
        if (rightStack.isEmpty()) return null

        if (leftStack.isEmpty()) {
            leftStack = ArrayList(rightStack.asReversed())
            rightStack = arrayListOf()
        }

        return leftStack.removeAt(leftStack.size - 1)
    }

    override val count = leftStack.size + rightStack.size

    override fun peek(): T? {
        return if (!leftStack.isEmpty()) leftStack.lastOrNull() else rightStack.firstOrNull()
    }
}