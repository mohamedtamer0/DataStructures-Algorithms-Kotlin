package `03-linked-list`

import example

fun main() {

    //creating and linking nodes
    "creating and linking nodes" example {
        val node1 = Node(value = 1)
        val node2 = Node(value = 2)
        val node3 = Node(value = 3)
        node1.next = node2
        node2.next = node3
        println("creating and linking nodes")
        println(node1)
    }
    println("========================")


    //Push > O(1)
    "push" example {
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)
        println(list)
    }
    println("========================")

    //Append > O(1)
    "append" example {
        val list2 = LinkedList<Int>()
        list2.append(1)
        list2.append(2)
        list2.append(3)
        println(list2)
    }
    println("========================")


    //Insert > O(1)
    "inserting at a particular index" example {
        val list3 = LinkedList<Int>()
        list3.push(3)
        list3.push(2)
        list3.push(1)
        println("Before inserting: $list3")
        var midNode = list3.nodeAt(1)!!
        for (i in 1..3) {
            midNode = list3.insert(-1 * i, midNode)
        }
        println("After inserting: $list3")
    }

    println("========================")


    //POP > O(1)
    "pop" example {
        val list4 = LinkedList<Int>()
        list4.push(3)
        list4.push(2)
        list4.push(1)
        println("Before popping list: $list4")
        val poppedValue = list4.pop()
        val poppedValue1 = list4.pop()
        println("After popping list: $list4")
        println("Popped value: $poppedValue")
        println("Popped value: $poppedValue1")
    }
    println("========================")


    //RemoveLast > O(n)
    "removing the last node" example {
        val list5 = LinkedList<Int>()
        list5.push(3)
        list5.push(2)
        list5.push(1)
        println("Before removing last node: $list5")
        val removedValue = list5.removeLast()
        println("After removing last node: $list5")
        println("Removed value: $removedValue")
    }
    println("========================")


    //RemoveAfter > O(1)
    "removing a node after a particular node" example {
        val list6 = LinkedList<Int>()
        list6.push(3)
        list6.push(2)
        list6.push(1)
        println("Before removing at particular index: $list6")
        val index = 1
        val node = list6.nodeAt(index - 1)!!
        val removedAfterValue = list6.removeAfter(node)
        println("After removing at index $index: $list6")
        println("Removed value: $removedAfterValue")
    }
    println("========================")


    //"printing doubles" LinkedListIterator
    "printing doubles" example {
        val list7 = LinkedList<Int>()
        list7.push(4)
        list7.push(3)
        list7.push(2)
        list7.push(1)
        println(list7)
        for (item in list7) {
            println("Double: ${item * 2}")
        }
    }
    println("========================")

    "removing elements" example {
        val list8: MutableCollection<Int> = LinkedList()
        list8.add(3)
        list8.add(2)
        list8.add(1)
        println(list8)
        list8.remove(1)
        println(list8)
    }

    "retaining elements" example {
        val list9: MutableCollection<Int> = LinkedList()
        list9.add(3)
        list9.add(2)
        list9.add(1)
        list9.add(4)
        list9.add(5)
        println(list9)
        list9.retainAll(listOf(3, 4, 5))
        println(list9)
    }


    "remove all elements" example {
        val list10: MutableCollection<Int> = LinkedList()
        list10.add(3)
        list10.add(2)
        list10.add(1)
        list10.add(4)
        list10.add(5)
        println(list10)
        list10.removeAll(listOf(3, 4, 5))
        println(list10)
    }


}