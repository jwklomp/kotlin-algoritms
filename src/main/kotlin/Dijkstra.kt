package org.jwk

import java.util.PriorityQueue

fun <T> dijkstra(
    graph: Map<T, List<Pair<T, Int>>>,
    start: T,
): Map<T, Int> {
    val distances = mutableMapOf<T, Int>().withDefault { Int.MAX_VALUE }
    val priorityQueue = PriorityQueue<Pair<T, Int>>(compareBy { it.second })
    val visited = mutableSetOf<T>()

    priorityQueue.add(start to 0)
    distances[start] = 0

    while (priorityQueue.isNotEmpty()) {
        val (node, currentDist) = priorityQueue.poll()
        println("processing node: $node, currentDist: $currentDist")
        if (visited.add(node)) {
            graph[node]?.forEach { (adjacent, weight) ->
                val totalDist = currentDist + weight
                if (totalDist < distances.getValue(adjacent)) {
                    println("setting/updating distance for $adjacent: ${distances[adjacent]}, totalDist: $totalDist")
                    distances[adjacent] = totalDist
                    priorityQueue.add(adjacent to totalDist)
                } else {
                    println("skipping distance update for $adjacent: ${distances[adjacent]}, totalDist: $totalDist")
                }
            }
        }
    }
    return distances
}
