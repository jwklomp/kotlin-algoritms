package org.jwk

import java.util.PriorityQueue

fun <T> dijkstra(
    graph: Graph<T>,
    start: T,
): Map<T, Int> {
    val distances = mutableMapOf<T, Int>().withDefault { Int.MAX_VALUE }
    val priorityQueue = PriorityQueue<Pair<T, Int>>(compareBy { it.second })
    val visited = mutableSetOf<T>()

    priorityQueue.add(start to 0)
    distances[start] = 0

    while (priorityQueue.isNotEmpty()) {
        val (node, currentDist) = priorityQueue.poll()
        println("Processing node: $node, current distance: $currentDist")

        // Skip already visited nodes
        if (visited.contains(node)) continue
        visited.add(node)

        // Explore adjacent nodes and update distances
        graph.getEdgesForNode(node).forEach { edge ->
            val adjacent = if (edge.first == node) edge.second else edge.first
            val totalDist = currentDist + edge.weight

            if (totalDist < distances.getValue(adjacent)) {
                println("Updating distance for $adjacent: old = ${distances.getValue(adjacent)}, new = $totalDist")
                distances[adjacent] = totalDist
                priorityQueue.add(adjacent to totalDist)
            } else {
                println("Skipping update for $adjacent: old = ${distances.getValue(adjacent)}, new = $totalDist")
            }
        }
    }

    println("Final distances: $distances")
    return distances
}
