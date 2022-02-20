package `03-linked-list`

fun main() {

    //creating and linking nodes
    val node1 = Node(value = 1)
    val node2 = Node(value = 2)
    val node3 = Node(value = 3)
    node1.next = node2
    node2.next = node3
    println("creating and linking nodes")
    println(node1)


    //Push
    val list = LinkedList<Int>()
    list.push(3)
    list.push(2)
    list.push(1)
    println("Push")
    println(list)


    //Append
    val list2 = LinkedList<Int>()
    list2.append(1)
    list2.append(2)
    list2.append(3)
    println("Append")
    println(list2)

}