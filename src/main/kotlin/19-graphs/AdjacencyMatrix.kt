package `19-graphs`

class AdjacencyMatrix<T: Any> : Graph<T> {

    private val vertices = arrayListOf<Vertex<T>>()
    private val weights = arrayListOf<ArrayList<Double?>>()

    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(vertices.count(), data)
        vertices.add(vertex)
        weights.forEach {
            it.add(null)
        }
        val row = ArrayList<Double?>(vertices.count())
        repeat(vertices.count()) {
            row.add(null)
        }
        weights.add(row)
        return vertex
    }

    override fun addDirectedEdge(
        source: Vertex<T>,
        destination: Vertex<T>,
        weight: Double?
    ) {
        weights[source.index][destination.index] = weight
    }

    override fun edges(source: Vertex<T>): ArrayList<Edge<T>> {
        val edges = arrayListOf<Edge<T>>()
        (0 until weights.size).forEach { column ->
            val weight = weights[source.index][column]
            if (weight != null) {
                edges.add(Edge(source, vertices[column], weight))
            }
        }
        return edges
    }

    override fun weight(
        source: Vertex<T>,
        destination: Vertex<T>
    ): Double? {
        return weights[source.index][destination.index]
    }

    override fun toString(): String {
        val verticesDescription = vertices
            .joinToString(separator = "\n") { "${it.index}: ${it.data}" }

        val grid = weights.map { row ->
            buildString {
                (0 until weights.size).forEach { columnIndex ->
                    val value = row[columnIndex]
                    if (value != null) {
                        append("$value\t")
                    } else {
                        append("ø\t\t")
                    }
                }
            }
        }

        val edgesDescription = grid.joinToString("\n")
        return "$verticesDescription\n\n$edgesDescription"
    }

}