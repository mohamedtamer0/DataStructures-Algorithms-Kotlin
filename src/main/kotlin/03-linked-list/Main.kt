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
    println("========================")

    //Push > O(1)
    val list = LinkedList<Int>()
    list.push(3)
    list.push(2)
    list.push(1)
    println("Push")
    println(list)
    println("========================")



    //Append > O(1)
    val list2 = LinkedList<Int>()
    list2.append(1)
    list2.append(2)
    list2.append(3)
    println("Append")
    println(list2)
    println("========================")

    //Insert > O(1)
    val list3 = LinkedList<Int>()
    list3.push(3)
    list3.push(2)
    list3.push(1)
    println("Insert")
    println("Before inserting: $list3")
    var midNode = list3.nodeAt(1)!!
    for (i in 1..3) {
        midNode = list3.insert(-1 * i, midNode)
    }
    println("After inserting: $list3")
    println("========================")



    //POP
    val list4 = LinkedList<Int>()
    list4.push(3)
    list4.push(2)
    list4.push(1)
    println("POP")
    println("Before popping list: $list4")
    val poppedValue = list4.pop()
    println("After popping list: $list4")
    println("Popped value: $poppedValue")
    println("========================")




}