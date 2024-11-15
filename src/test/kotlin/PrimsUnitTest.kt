import org.junit.jupiter.api.Test
import org.jwk.Edge
import org.jwk.Graph
import org.jwk.prims
import kotlin.test.assertEquals

class PrimsUnitTest {
    @Test
    fun testPrims() {
        val graph = Graph(setOf(
            Edge(first = "a", second = "b", weight = 8),
            Edge(first = "a", second = "c", weight = 5),
            Edge(first = "b", second = "c", weight = 9),
            Edge(first = "b", second = "d", weight = 11),
            Edge(first = "c", second = "d", weight = 15),
            Edge(first = "c", second = "e", weight = 10),
            Edge(first = "d", second = "e", weight = 7),
        ))

        val msp = prims(graph)
        println(msp)

        assertEquals(Graph(setOf(
            Edge(first = "a", second = "b", weight = 8),
            Edge(first = "a", second = "c", weight = 5),
            Edge(first = "c", second = "e", weight = 10),
            Edge(first = "d", second = "e", weight = 7),
        )), msp)
    }
}
