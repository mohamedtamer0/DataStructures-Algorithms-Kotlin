package `19-graphs`

data class Edge<T : Any>(val source: Vertex<T>, val destination: Vertex<T>, val weight: Double? = null)
