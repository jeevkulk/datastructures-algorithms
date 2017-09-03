package datastructure.graph;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdjacencyMatrixGraphTest {

    private Logger logger = LogManager.getLogger(AdjacencyMatrixGraphTest.class);

    private AdjacencyMatrixGraph<String> adjacencyMatrixGraph;

    @Test
    public void testUndirectedAdjacencyMatrixGraph() {
        adjacencyMatrixGraph = new AdjacencyMatrixGraph<>(4, false);
        Graph.Vertex vertex1 = adjacencyMatrixGraph.createVertex("0");
        Graph.Vertex vertex2 = adjacencyMatrixGraph.createVertex("1");
        Graph.Vertex vertex3 = adjacencyMatrixGraph.createVertex("2");
        Graph.Vertex vertex4 = adjacencyMatrixGraph.createVertex("3");

        adjacencyMatrixGraph.addEdge(vertex1, vertex2, 1);
        adjacencyMatrixGraph.addEdge(vertex1, vertex3, 1);
        adjacencyMatrixGraph.addEdge(vertex2, vertex4, 1);
        adjacencyMatrixGraph.addEdge(vertex3, vertex4, 1);
        adjacencyMatrixGraph.addEdge(vertex1, vertex4, 1);

        Assert.assertEquals("x 1 1 1 1 x x 1 1 x x 1 1 1 1 x ", adjacencyMatrixGraph.toString());
    }

    @Test
    public void testDirectedAdjacencyMatrixGraph() {
        adjacencyMatrixGraph = new AdjacencyMatrixGraph<>(4, true);
        Graph.Vertex vertex1 = adjacencyMatrixGraph.createVertex("0");
        Graph.Vertex vertex2 = adjacencyMatrixGraph.createVertex("1");
        Graph.Vertex vertex3 = adjacencyMatrixGraph.createVertex("2");
        Graph.Vertex vertex4 = adjacencyMatrixGraph.createVertex("3");

        adjacencyMatrixGraph.addEdge(vertex1, vertex2, 1);
        adjacencyMatrixGraph.addEdge(vertex1, vertex3, 1);
        adjacencyMatrixGraph.addEdge(vertex2, vertex4, 1);
        adjacencyMatrixGraph.addEdge(vertex3, vertex4, 1);
        adjacencyMatrixGraph.addEdge(vertex1, vertex4, 1);

        Assert.assertEquals("x 1 1 1 x x x 1 x x x 1 x x x x ", adjacencyMatrixGraph.toString());
    }

    @Test
    public void testGetLinkedEdges() {
        adjacencyMatrixGraph = new AdjacencyMatrixGraph<>(4, true);
        Graph.Vertex vertex1 = adjacencyMatrixGraph.createVertex("Zero");
        Graph.Vertex vertex2 = adjacencyMatrixGraph.createVertex("One");
        Graph.Vertex vertex3 = adjacencyMatrixGraph.createVertex("Two");
        Graph.Vertex vertex4 = adjacencyMatrixGraph.createVertex("Three");

        adjacencyMatrixGraph.addEdge(vertex1, vertex2, 1);
        adjacencyMatrixGraph.addEdge(vertex1, vertex3, 1);
        adjacencyMatrixGraph.addEdge(vertex2, vertex4, 1);
        adjacencyMatrixGraph.addEdge(vertex3, vertex4, 1);
        adjacencyMatrixGraph.addEdge(vertex1, vertex4, 1);

        Graph.Edge[] edgeArr = adjacencyMatrixGraph.getLinkedEdges(vertex3);
        for (int i = 0; i < edgeArr.length; i++) {
            if (edgeArr[i] != null)
                logger.info(edgeArr[i].toString());
        }
        Assert.assertEquals("Edge{id=3, vertexFrom=Vertex{id=2, t=Two}, vertexTo=Vertex{id=3, t=Three}, weight=1}", adjacencyMatrixGraph.getLinkedEdges(vertex3)[3].toString());
    }

    @Test
    public void testGetLinkedVertices() {
        adjacencyMatrixGraph = new AdjacencyMatrixGraph<>(4, true);
        Graph.Vertex vertex1 = adjacencyMatrixGraph.createVertex("Zero");
        Graph.Vertex vertex2 = adjacencyMatrixGraph.createVertex("One");
        Graph.Vertex vertex3 = adjacencyMatrixGraph.createVertex("Two");
        Graph.Vertex vertex4 = adjacencyMatrixGraph.createVertex("Three");

        adjacencyMatrixGraph.addEdge(vertex1, vertex2, 1);
        adjacencyMatrixGraph.addEdge(vertex1, vertex3, 1);
        adjacencyMatrixGraph.addEdge(vertex2, vertex4, 1);
        adjacencyMatrixGraph.addEdge(vertex3, vertex4, 1);
        adjacencyMatrixGraph.addEdge(vertex1, vertex4, 1);

        Graph.Vertex[] vertexArr = adjacencyMatrixGraph.getLinkedVertices(vertex3);
        for (int i = 0; i < vertexArr.length; i++) {
            if (vertexArr[i] != null)
                logger.info(vertexArr[i].toString());
        }
        Assert.assertEquals("Vertex{id=3, t=Three}", adjacencyMatrixGraph.getLinkedVertices(vertex3)[3].toString());
    }
}
