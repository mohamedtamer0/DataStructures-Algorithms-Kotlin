package `19-graphs`


interface Graph<T : Any> {
    fun createVertex(data: T): Vertex<T>

    fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?)

    fun addUndirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        addDirectedEdge(source, destination, weight)
        addDirectedEdge(destination, source, weight)
    }

    fun add(edge: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        when (edge) {
            EdgeType.DIRECTED -> addDirectedEdge(source, destination, weight)
            EdgeType.UNDIRECTED -> addUndirectedEdge(source, destination, weight)
        }
    }

    fun edges(source: Vertex<T>): ArrayList<Edge<T>>

    fun weight(source: Vertex<T>, destination: Vertex<T>): Double?

}

enum class EdgeType {
    DIRECTED,
    UNDIRECTED
}