package `06-trees`.challenge

import `05-queue-data-structure`.base.list.ArrayListQueue


/*
Challenge : Tree challenge
Print the values in a tree in an order based on their level. Nodes belonging to the
same level should be printed on the same line. For example, consider the following
tree:
 */

class TreeNodeChallenge<T>(val value: T) {
    private val children: MutableList<TreeNodeChallenge<T>> = mutableListOf()

    fun add(child: TreeNodeChallenge<T>) = children.add(child)

    //Solution
    fun printEachLevel() {
        val queue = ArrayListQueue<TreeNodeChallenge<T>>()
        var nodesLeftCurrentLevel = 0

        queue.enqueue(this)
        while (queue.isEmpty.not()) {
            nodesLeftCurrentLevel = queue.count

            while (nodesLeftCurrentLevel > 0) {
                val node = queue.dequeue()
                node?.let {
                    print("${node.value} ")
                    node.children.forEach { queue.enqueue(it) }
                    nodesLeftCurrentLevel--
                } ?: break
            }
            println()
        }
    }
}

fun main() {
    val tree = makeTree()
    tree.printEachLevel()
}


fun makeTree(): TreeNodeChallenge<Int> {
    // Build the sample tree shown in the diagram
    // Root of the tree
    val tree = TreeNodeChallenge(15)

    // Second level
    val one = TreeNodeChallenge(1)
    tree.add(one)

    val seventeen = TreeNodeChallenge(17)
    tree.add(seventeen)

    val twenty = TreeNodeChallenge(20)
    tree.add(twenty)

    // Third level
    val one2 = TreeNodeChallenge(1)
    val five = TreeNodeChallenge(5)
    val zero = TreeNodeChallenge(0)
    one.add(one2)
    one.add(five)
    one.add(zero)

    val two = TreeNodeChallenge(2)
    seventeen.add(two)

    val five2 = TreeNodeChallenge(5)
    val seven = TreeNodeChallenge(7)
    twenty.add(five2)
    twenty.add(seven)

    return tree
}