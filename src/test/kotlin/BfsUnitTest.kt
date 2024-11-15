import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.jwk.Edge
import org.jwk.Graph
import org.jwk.bfs

class BfsUnitTest {

    @Test
    fun `test BFS traversal order`() {
        val edges = listOf(
            Edge(1, 2, 1), // Edge from node 1 to node 2 with weight 1
            Edge(1, 3, 1), // Edge from node 1 to node 3 with weight 1
            Edge(1, 4, 1), // Edge from node 1 to node 4 with weight 1
            Edge(2, 5, 1), // Edge from node 2 to node 5 with weight 1
            Edge(2, 6, 1), // Edge from node 2 to node 6 with weight 1
            Edge(4, 7, 1), // Edge from node 4 to node 7 with weight 1
            Edge(4, 8, 1)  // Edge from node 4 to node 8 with weight 1
        )

        val graph = Graph(edges)
        val traversalOrder = bfs(graph, 1)

        // Level 1
        assertEquals(listOf(1), listOf(traversalOrder.first()))

        // Level 2
        val levelTwo = traversalOrder.drop(1).take(3)
        assertEquals(listOf(2, 3, 4), levelTwo)

        // Level 3
        val levelThree = traversalOrder.drop(4)
        assertEquals(listOf(5, 6, 7, 8), levelThree)
    }
}
