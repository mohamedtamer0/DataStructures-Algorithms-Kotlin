package `22-dijkstras-algorithm`

import `05-queue-data-structure`.base.doublestack.StackImpl
import `19-graphs`.Edge
import `19-graphs`.Vertex
import `20-breadth-first-search`.QueueStack
import `20-breadth-first-search`.Ref

abstract class Graph<T: Any> {

    abstract fun createVertex(data: T): Vertex<T>
    abstract fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?)
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

    abstract fun edges(source: Vertex<T>): ArrayList<Edge<T>>
    abstract fun weight(source: Vertex<T>, destination: Vertex<T>): Double?

    fun numberOfPaths(source: Vertex<T>, destination: Vertex<T>): Int {
        val numberOfPaths = Ref(0) // 1
        val visited: ArrayList<Vertex<T>> = arrayListOf() // 2
        paths(source, destination, visited, numberOfPaths) // 3
        return numberOfPaths.value
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

    fun breadthFirstSearch(source: Vertex<T>): ArrayList<Vertex<T>> {
        val queue = QueueStack<Vertex<T>>()
        val enqueued = ArrayList<Vertex<T>>()
        val visited = ArrayList<Vertex<T>>()

        queue.enqueue(source)
        enqueued.add(source)

        while (true) {
            val vertex = queue.dequeue() ?: break

            visited.add(vertex)

            val neighborEdges = edges(vertex)
            neighborEdges.forEach {
                if (!enqueued.contains(it.destination)) {
                    queue.enqueue(it.destination)
                    enqueued.add(it.destination)
                }
            }
        }

        return visited
    }

    fun depthFirstSearch(source: Vertex<T>): ArrayList<Vertex<T>> {
        val stack = StackImpl<Vertex<T>>()
        val visited = arrayListOf<Vertex<T>>()
        val pushed = arrayListOf<Vertex<T>>()

        stack.push(source)
        pushed.add(source)
        visited.add(source)

        outer@ while (true) {
            if (stack.isEmpty) break

            val vertex = stack.peek()
            val neighbors = edges(vertex!!)

            if (neighbors.isEmpty()) {
                stack.pop()
                continue
            }

            for (i in 0 until neighbors.size) {
                val destination = neighbors[i].destination
                if (!pushed.contains(destination)) {
                    stack.push(destination)
                    pushed.add(destination)
                    visited.add(destination)
                    continue@outer
                }
            }
            stack.pop()
        }

        return visited
    }

}

enum class EdgeType {
    DIRECTED,
    UNDIRECTED
}