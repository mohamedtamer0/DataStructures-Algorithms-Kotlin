package `08-binary-search-trees`

import `07-binary-trees`.BinaryNode


class BinarySearchTree<T : Comparable<T>> {
    var root: BinaryNode<T>? = null
    override fun toString() = root?.toString() ?: "empty tree"

    fun insert(value: T) {
        root = insert(root, value)
    }

    private fun insert(
        node: BinaryNode<T>?,
        value: T
    ): BinaryNode<T> {
        //1
        node ?: return BinaryNode(value)
        //2
        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value)
        } else {
            node.rightChild = insert(node.rightChild, value)
        }
        //3
        return node
    }


    fun remove(value: T) {
        root = remove(root, value)
    }

    private fun remove(
        node: BinaryNode<T>?,
        value: T
    ): BinaryNode<T>? {
        node ?: return null

        when {
            value == node.value -> {
                // 1
                if (node.leftChild == null && node.rightChild == null) {
                    return null
                }
                // 2
                if (node.leftChild == null) {
                    return node.rightChild
                }
                // 3
                if (node.rightChild == null) {
                    return node.leftChild
                }
                // 4
                node.rightChild?.min?.value?.let {
                    node.value = it
                }

                node.rightChild = remove(node.rightChild, node.value)
            }
            value < node.value -> node.leftChild = remove(node.leftChild, value)
            else -> node.rightChild = remove(node.rightChild, value)
        }
        return node
    }


    fun contains(value: T): Boolean {
        //1
        var current = root

        //2
        while (current != null) {
            //3
            if (current.value == value) {
                return true
            }

            //4
            current = if (value < current.value) {
                current.leftChild
            } else {
                current.rightChild
            }
        }
        return false
    }

}