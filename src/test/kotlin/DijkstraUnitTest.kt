import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.jwk.Edge
import org.jwk.Graph
import org.jwk.dijkstra

class DijkstraUnitTest {
    @Test
    fun `Should calculate shortest path when using Dijkstra algorithm`() {
        val edges = listOf(
            Edge(1, 2, 10),
            Edge(1, 3, 15),
            Edge(2, 4, 12),
            Edge(3, 4, 15),
            Edge(4, 5, 12),
            Edge(4, 6, 15)
        )
        val graph = Graph(edges)

        val shortestPaths = dijkstra(graph, 1)
        assertEquals(37, shortestPaths.getValue(6))
    }

    @Test
    fun `Should calculate shortest path when using Dijkstra algorithm for larger example`() {
        val edges = listOf(
            Edge(1, 2, 7), Edge(1, 3, 9), Edge(1, 6, 14),
            Edge(2, 3, 10), Edge(2, 4, 15),
            Edge(3, 4, 11), Edge(3, 6, 2),
            Edge(4, 5, 6),
            Edge(5, 6, 9), Edge(5, 9, 3),
            Edge(6, 7, 10),
            Edge(7, 8, 2),
            Edge(8, 9, 1)
        )
        val graph = Graph(edges)

        val shortestPaths = dijkstra(graph, 1)

        // Expected shortest distances from node 1 to various nodes
        assertEquals(23, shortestPaths.getValue(9))
    }
}
