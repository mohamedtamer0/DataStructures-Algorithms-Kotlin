package `20-breadth-first-search`

import `19-graphs`.Edge
import `19-graphs`.Vertex

interface Graph<T: Any> {

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

    fun numberOfPaths(source: Vertex<T>, destination: Vertex<T>): Int {
        val numberOfPaths = Ref(0) // 1
        val visited: ArrayList<Vertex<T>> = arrayListOf() // 2
        paths(source, destination, visited, numberOfPaths) // 3
        return numberOfPaths.value
    }

    fun breadthFirstSearch(source: Vertex<T>): ArrayList<Vertex<T>> {
        val queue = QueueStack<Vertex<T>>()
        val enqueued = mutableSetOf<Vertex<T>>()
        val visited = ArrayList<Vertex<T>>()
        queue.enqueue(source) // 1
        enqueued.add(source)
        while (true) {
            val vertex = queue.dequeue() ?: break // 2
            visited.add(vertex) // 3
            val neighborEdges = edges(vertex) // 4
            neighborEdges.forEach {
                if (!enqueued.contains(it.destination)) { // 5
                    queue.enqueue(it.destination)
                    enqueued.add(it.destination)
                }
            }
        }
        return visited
    }

    fun paths(source: Vertex<T>, destination: Vertex<T>, visited: ArrayList<Vertex<T>>, pathCount: Ref<Int>) {
        visited.add(source) // 1
        if (source == destination) { // 2
            pathCount.value += 1
        } else {
            val neighbors = edges(source) // 3
            neighbors.forEach { edge ->
                // 4
                if (!visited.contains(edge.destination)) {
                    paths(edge.destination, destination, visited, pathCount)
                }
            }
        }
        // 5
        visited.remove(source)
    }

}

enum class EdgeType {
    DIRECTED,
    UNDIRECTED
}