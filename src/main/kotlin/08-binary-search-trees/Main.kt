package `08-binary-search-trees`

import example

fun main() {
    "building a BST" example {
        val bst = BinarySearchTree<Int>()
        (0..4).forEach {
            bst.insert(it)
        }
        println(bst)
    }
}