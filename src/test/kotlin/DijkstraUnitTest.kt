
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.jwk.dijkstra

class DijkstraUnitTest {
    @Test
    fun `Should calculate shortest path when using Dijkstra algorithm`() {
        val graph =
            mapOf(
                1 to listOf(Pair(2, 10), Pair(3, 15)),
                2 to listOf(Pair(4, 12)),
                3 to listOf(Pair(4, 15)),
                4 to listOf(Pair(5, 12), Pair(6, 15)),
                5 to emptyList(),
                6 to emptyList(),
            )

        val shortestPaths = dijkstra(graph, 1)
        assertEquals(37, shortestPaths.getValue(6))
    }

    @Test
    fun `Should calculate shortest path when using Dijkstra algorithm for larger example`() {
        val largeGraph =
            mapOf(
                1 to listOf(2 to 7, 3 to 9, 6 to 14),
                2 to listOf(1 to 7, 3 to 10, 4 to 15),
                3 to listOf(1 to 9, 2 to 10, 4 to 11, 6 to 2),
                4 to listOf(2 to 15, 3 to 11, 5 to 6),
                5 to listOf(4 to 6, 6 to 9),
                6 to listOf(1 to 14, 3 to 2, 5 to 9, 7 to 10),
                7 to listOf(6 to 10, 8 to 2),
                8 to listOf(7 to 2, 5 to 6, 9 to 1),
                9 to listOf(8 to 1, 5 to 3),
                10 to emptyList(), // node with no outgoing edges
            )

        val shortestPaths = dijkstra(largeGraph, 1)

        // Expected shortest distances from node 1 to various nodes
        assertEquals(24, shortestPaths.getValue(9))
    }
}
