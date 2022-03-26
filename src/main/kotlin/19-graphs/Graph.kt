package `19-graphs`



interface Graph<T: Any> {
    fun createVertex(data: T): Vertex<T>

    fun addDirectEdge(source:Vertex<T>, destination:Vertex<T>, weight:Double?)

}