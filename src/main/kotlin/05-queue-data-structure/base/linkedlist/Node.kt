package `05-queue-data-structure`.base.linkedlist

data class Node<T : Any>(var value: T, var next: Node<T>? = null, var previous: Node<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }
}