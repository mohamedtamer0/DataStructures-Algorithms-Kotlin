package `10-trie`

import example

fun main() {
    "insert and contains" example {
        val trie = Trie<Char>()
        trie.insert("cute".toList())
        if (trie.contains("cute".toList())) {
            println("cute is in the trie")
        }
    }
}