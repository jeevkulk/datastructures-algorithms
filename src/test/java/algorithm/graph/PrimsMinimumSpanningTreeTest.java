package algorithm.graph;

import datastructure.graph.AdjacencyMatrixGraph;
import datastructure.graph.Graph;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PrimsMinimumSpanningTreeTest {

    @Test
    public void test() {
        PrimsMinimumSpanningTree primsMinimumSpanningTree = null;
        AdjacencyMatrixGraph<Integer> adjacencyMatrixGraph = null;

        adjacencyMatrixGraph = new AdjacencyMatrixGraph<>(5, false);
        Graph.Vertex vertex0 = adjacencyMatrixGraph.createVertex(0);
        Graph.Vertex vertex1 = adjacencyMatrixGraph.createVertex(1);
        Graph.Vertex vertex2 = adjacencyMatrixGraph.createVertex(2);
        Graph.Vertex vertex3 = adjacencyMatrixGraph.createVertex(3);
        Graph.Vertex vertex4 = adjacencyMatrixGraph.createVertex(4);

        adjacencyMatrixGraph.addEdge(vertex0, vertex1, 1);
        adjacencyMatrixGraph.addEdge(vertex0, vertex2, 2);
        adjacencyMatrixGraph.addEdge(vertex1, vertex3, 1);
        adjacencyMatrixGraph.addEdge(vertex2, vertex3, 1);
        adjacencyMatrixGraph.addEdge(vertex3, vertex4, 2);

        primsMinimumSpanningTree = new PrimsMinimumSpanningTree(adjacencyMatrixGraph);
        primsMinimumSpanningTree.findMinimumSpanningTree();
    }
}
