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


}