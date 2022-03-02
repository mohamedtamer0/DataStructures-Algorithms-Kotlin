package `10-trie`

class Trie<Key : Any> {
    private val root = TrieNode<Key>(null, null)

    fun insert(list: List<Key>) {
        //1
        var current = root

        //2
        list.forEach { element ->
            val child = current.children[element] ?: TrieNode(element, current)
            current.children[element] = child
            current = child
        }
        //3
        current.isTerminating = true
    }


    fun contains(list: List<Key>): Boolean {
        var current = root
        list.forEach { element ->
            val child = current.children[element] ?: return false
            current = child
        }
        return current.isTerminating
    }

    fun remove(list: List<Key>) {
        //1
        var current = root
        list.forEach { element ->
            val child = current.children[element] ?: return
            current = child
        }

        if (!current.isTerminating) return

        //2
        current.isTerminating = false

        //3
        val parent = current.parent
        while (parent != null && current.children.isEmpty() && !current.isTerminating) {
            parent.children.remove(current.key)
            current = parent
        }
    }

    fun collections(prefix: List<Key>): List<List<Key>> {
        // 1
        var current = root

        prefix.forEach { element ->
            val child = current.children[element] ?: return emptyList()
            current = child
        }

        // 2
        return collections(prefix, current)
    }

    private fun collections(prefix: List<Key>, node: TrieNode<Key>?): List<List<Key>> {
        // 1
        val results = mutableListOf<List<Key>>()

        if (node?.isTerminating == true) {
            results.add(prefix)
        }

        // 2
        node?.children?.forEach { (key, node) ->
            results.addAll(collections(prefix + key, node))
        }

        return results
    }

}