package org.jwk

data class Graph<T>(val edges: Collection<Edge<T>>) {
    fun getNodes(): Collection<T> {
        return edges.flatMap { listOf(it.first, it.second) }.distinct()
    }

    fun getEdgesForNode(node: T): Collection<Edge<T>> {
        return edges.filter { it.first == node || it.second == node }
    }
}
