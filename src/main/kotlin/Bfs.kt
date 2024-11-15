package org.jwk

fun <T> bfs(graph: Graph<T>, start: T): Set<T> {
    val visited = mutableSetOf<T>()
    val queue = ArrayDeque<T>()
    queue.add(start)

    while (queue.isNotEmpty()) {
        val vertex = queue.removeFirst()
        if (vertex !in visited) {
            visited.add(vertex)
            // Get the neighbors of the current vertex (node)
            graph.getEdgesForNode(vertex).forEach { edge ->
                val neighbor = if (edge.first == vertex) edge.second else edge.first
                if (neighbor !in visited) {
                    queue.add(neighbor)
                }
            }
        }
    }
    return visited
}
