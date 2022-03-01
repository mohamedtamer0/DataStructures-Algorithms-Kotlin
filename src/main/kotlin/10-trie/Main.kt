package `10-trie`

import example

fun main() {
    "insert and contains" example {
        val trie = Trie<Char>()
        trie.insert("cute")
        if (trie.contains("cute")) {
            println("cute is in the trie")
        }
    }


}