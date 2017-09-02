package datastructure.graph;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdjacencyLinkedListGraphTest {

    private AdjacencyLinkedListGraph<String> adjacencyLinkedListGraph;

    @Test
    public void testAdjacencyLinkedListGraph() {
        adjacencyLinkedListGraph = new AdjacencyLinkedListGraph<>(4, false);
        Graph.Vertex vertex1 = adjacencyLinkedListGraph.createVertex("One");
        Graph.Vertex vertex2 = adjacencyLinkedListGraph.createVertex("Two");
        Graph.Vertex vertex3 = adjacencyLinkedListGraph.createVertex("Three");
        Graph.Vertex vertex4 = adjacencyLinkedListGraph.createVertex("Four");

        adjacencyLinkedListGraph.addEdge(vertex1, vertex2, 1);
        adjacencyLinkedListGraph.addEdge(vertex1, vertex3, 1);
        adjacencyLinkedListGraph.addEdge(vertex2, vertex4, 1);
        adjacencyLinkedListGraph.addEdge(vertex3, vertex4, 1);
        adjacencyLinkedListGraph.addEdge(vertex1, vertex4, 1);

        adjacencyLinkedListGraph.toString();
    }
}
