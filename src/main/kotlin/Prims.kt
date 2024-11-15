package org.jwk

fun <T> prims(graph: Graph<T>): Graph<T> {
    val visitedNodes = mutableSetOf<T>()
    val edges = mutableSetOf<Edge<T>>()

    visitedNodes.add(graph.getNodes().random())

    while (!visitedNodes.containsAll(graph.getNodes())) {
        val nextEdge = visitedNodes
            .flatMap { graph.getEdgesForNode(it) }
            .filter { !visitedNodes.contains(it.first) || !visitedNodes.contains(it.second) }
            .minByOrNull { it.weight }

        if (nextEdge != null) {
            visitedNodes.addAll(setOf(nextEdge.first, nextEdge.second))
            edges.add(nextEdge)
        }
    }

    return Graph(edges)
}
