package datastructure.graph;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdjacencyMatrixGraphTest {

    private AdjacencyMatrixGraph<String> adjacencyMatrixGraph;

    @Test
    public void testAdjacencyMatrixGraph() {
        adjacencyMatrixGraph = new AdjacencyMatrixGraph<>(4, false);
        Graph.Vertex vertex1 = adjacencyMatrixGraph.createVertex("One");
        Graph.Vertex vertex2 = adjacencyMatrixGraph.createVertex("Two");
        Graph.Vertex vertex3 = adjacencyMatrixGraph.createVertex("Three");
        Graph.Vertex vertex4 = adjacencyMatrixGraph.createVertex("Four");

        adjacencyMatrixGraph.addEdge(vertex1, vertex2, 1);
        adjacencyMatrixGraph.addEdge(vertex1, vertex3, 1);
        adjacencyMatrixGraph.addEdge(vertex2, vertex4, 1);
        adjacencyMatrixGraph.addEdge(vertex3, vertex4, 1);
        adjacencyMatrixGraph.addEdge(vertex1, vertex4, 1);

        adjacencyMatrixGraph.toString();
    }
}
