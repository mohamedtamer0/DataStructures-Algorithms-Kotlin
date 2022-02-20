package `03-linked-list`

class LinkedList<T : Any> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        if (isEmpty()) {
            return "Empty List"
        } else {
            return head.toString()
        }
    }


    //Push
    fun push(value: T) {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
    }


    //Append
    fun append(value: T) {
        //1
        if (isEmpty()) {
            push(value)
            return
        }

        //2
        val newNode = Node(value = value)
        tail?.next = newNode

        //3
        tail = newNode
        size++
    }


    //Insert
    fun nodeAt(index: Int): Node<T>? {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    fun insert(value: T, afterNode: Node<T>): Node<T> {
        if (tail == afterNode) {
            append(value)
            return tail!!
        }

        val newNode = Node(value = value, next = afterNode.next)
        afterNode.next = newNode
        size++
        return newNode
    }


    //POP
    fun pop(): T? {
        if (isEmpty()) return null

        val result = head?.value
        head = head?.next
        size--
        if (isEmpty()) {
            tail = null
        }

        return result
    }


    //RemoveLast
    fun removeLast(): T? {
        val head = head ?: return null
        if (head.next == null) return pop()
        size--

        var prev = head
        var current = head
        var next = current.next

        while (next != null) {
            prev = current
            current = next
            next = current.next
        }

        prev.next = null
        tail = prev
        return current.value
    }


    //RemoveAfter
    fun removeAfter(node: Node<T>): T? {
        val result = node.next?.value
        if (node.next == tail) {
            tail = node
        }
        if (node.next != null) {
            size--
        }
        node.next = node.next?.next
        return result
    }


}