package `01-kotlin-and-kotlin-standard-library`

//class Box {
//    var content: Any? = null
//    fun put(content: Any?) {
//        this.content = content
//    }
//
//    fun retrieve():Any? {
//        return content
//    }
//    fun isEmpty():Boolean {
//        return content == null
//    }
//}

class Box<T> {
    var content: T? = null
    fun put(content: T?) {
        this.content = content
    }

    fun retrieve(): T? {
        return content
    }

    fun isEmpty(): Boolean {
        return content == null
    }
}

fun main() {
    val box = Box<Int>()
    box.put(4)
    val boolBox = Box<Boolean>()
    boolBox.put(true)
    boolBox.isEmpty()
}