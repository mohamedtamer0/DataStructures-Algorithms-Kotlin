package `09-avl-trees`

import example

fun main() {
    "repeated insertions in sequence" example {
        val tree = AVLTree<Int>()

        (0..14).forEach {
            tree.insert(it)
        }

        print(tree)
    }
}