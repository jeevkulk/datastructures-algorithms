package datastructure.graph;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdjacencyLinkedListGraphTest {

    private Logger logger = LogManager.getLogger(AdjacencyLinkedListGraphTest.class);

    private AdjacencyLinkedListGraph<String> adjacencyLinkedListGraph;

    @Test
    public void testUndirectedAdjacencyLinkedListGraph() {
        adjacencyLinkedListGraph = new AdjacencyLinkedListGraph<>(4, false);
        Graph.Vertex vertex1 = adjacencyLinkedListGraph.createVertex("0");
        Graph.Vertex vertex2 = adjacencyLinkedListGraph.createVertex("1");
        Graph.Vertex vertex3 = adjacencyLinkedListGraph.createVertex("2");
        Graph.Vertex vertex4 = adjacencyLinkedListGraph.createVertex("3");

        adjacencyLinkedListGraph.addEdge(vertex1, vertex2, 1);
        adjacencyLinkedListGraph.addEdge(vertex1, vertex3, 1);
        adjacencyLinkedListGraph.addEdge(vertex2, vertex4, 1);
        adjacencyLinkedListGraph.addEdge(vertex3, vertex4, 1);
        adjacencyLinkedListGraph.addEdge(vertex1, vertex4, 1);

        Assert.assertEquals("0->1 2 3 1->0 3 2->0 3 3->1 2 0 ", adjacencyLinkedListGraph.toString());
    }

    @Test
    public void testDirectedAdjacencyLinkedListGraph() {
        adjacencyLinkedListGraph = new AdjacencyLinkedListGraph<>(4, true);
        Graph.Vertex vertex1 = adjacencyLinkedListGraph.createVertex("0");
        Graph.Vertex vertex2 = adjacencyLinkedListGraph.createVertex("1");
        Graph.Vertex vertex3 = adjacencyLinkedListGraph.createVertex("2");
        Graph.Vertex vertex4 = adjacencyLinkedListGraph.createVertex("3");

        adjacencyLinkedListGraph.addEdge(vertex1, vertex2, 1);
        adjacencyLinkedListGraph.addEdge(vertex1, vertex3, 1);
        adjacencyLinkedListGraph.addEdge(vertex2, vertex4, 1);
        adjacencyLinkedListGraph.addEdge(vertex3, vertex4, 1);
        adjacencyLinkedListGraph.addEdge(vertex1, vertex4, 1);

        Assert.assertEquals("0->1 2 3 1->3 2->3 3->", adjacencyLinkedListGraph.toString());
    }

    @Test
    public void testGetLinkedEdges() {
        adjacencyLinkedListGraph = new AdjacencyLinkedListGraph<>(4, true);
        Graph.Vertex vertex1 = adjacencyLinkedListGraph.createVertex("0");
        Graph.Vertex vertex2 = adjacencyLinkedListGraph.createVertex("1");
        Graph.Vertex vertex3 = adjacencyLinkedListGraph.createVertex("2");
        Graph.Vertex vertex4 = adjacencyLinkedListGraph.createVertex("3");

        adjacencyLinkedListGraph.addEdge(vertex1, vertex2, 1);
        adjacencyLinkedListGraph.addEdge(vertex1, vertex3, 1);
        adjacencyLinkedListGraph.addEdge(vertex2, vertex4, 1);
        adjacencyLinkedListGraph.addEdge(vertex3, vertex4, 1);
        adjacencyLinkedListGraph.addEdge(vertex1, vertex4, 1);

        Graph.Edge[] edgeArr = adjacencyLinkedListGraph.getLinkedEdges(vertex3);
        for (int i = 0; i < edgeArr.length; i++) {
            if (edgeArr[i] != null)
                logger.info(edgeArr[i].toString());
        }
        Assert.assertEquals("Edge{id=3, vertexFrom=Vertex{id=2, t=2}, vertexTo=Vertex{id=3, t=3}, weight=1}", adjacencyLinkedListGraph.getLinkedEdges(vertex3)[0].toString());
    }

    @Test
    public void testGetLinkedVertices() {
        adjacencyLinkedListGraph = new AdjacencyLinkedListGraph<>(4, true);
        Graph.Vertex vertex1 = adjacencyLinkedListGraph.createVertex("0");
        Graph.Vertex vertex2 = adjacencyLinkedListGraph.createVertex("1");
        Graph.Vertex vertex3 = adjacencyLinkedListGraph.createVertex("2");
        Graph.Vertex vertex4 = adjacencyLinkedListGraph.createVertex("3");

        adjacencyLinkedListGraph.addEdge(vertex1, vertex2, 1);
        adjacencyLinkedListGraph.addEdge(vertex1, vertex3, 1);
        adjacencyLinkedListGraph.addEdge(vertex2, vertex4, 1);
        adjacencyLinkedListGraph.addEdge(vertex3, vertex4, 1);
        adjacencyLinkedListGraph.addEdge(vertex1, vertex4, 1);

        Graph.Vertex[] verticesArr = adjacencyLinkedListGraph.getLinkedVertices(vertex3);
        for (int i = 0; i < verticesArr.length; i++) {
            if (verticesArr[i] != null)
                logger.info(verticesArr[i].toString());
        }
        Assert.assertEquals("Vertex{id=3, t=3}", adjacencyLinkedListGraph.getLinkedVertices(vertex3)[0].toString());
    }

    @Test
    public void testGetMotherVertices() {
        int numberOfVertices = 5;
        Graph<String>.Vertex<String>[] motherVertices = new Graph.Vertex[numberOfVertices];
        adjacencyLinkedListGraph = new AdjacencyLinkedListGraph<>(numberOfVertices,true);
        Graph.Vertex vertex0 = adjacencyLinkedListGraph.createVertex("Zero");
        Graph.Vertex vertex1 = adjacencyLinkedListGraph.createVertex("One");
        Graph.Vertex vertex2 = adjacencyLinkedListGraph.createVertex("Two");
        Graph.Vertex vertex3 = adjacencyLinkedListGraph.createVertex("Three");
        Graph.Vertex vertex4 = adjacencyLinkedListGraph.createVertex("Four");

        adjacencyLinkedListGraph.addEdge(vertex3, vertex4, 1);
        adjacencyLinkedListGraph.addEdge(vertex2, vertex4, 1);
        adjacencyLinkedListGraph.addEdge(vertex1, vertex4, 1);
        adjacencyLinkedListGraph.addEdge(vertex0, vertex4, 1);

        motherVertices = adjacencyLinkedListGraph.getMotherVertices();
        for (int i = 0; i < motherVertices.length; i++) {
            if (motherVertices[i] != null) {
                logger.info(motherVertices[i].toString());
            }
        }
        Assert.assertEquals("Vertex{id=0, t=Zero}", motherVertices[0].toString());
        Assert.assertEquals("Vertex{id=1, t=One}", motherVertices[1].toString());
        Assert.assertEquals("Vertex{id=2, t=Two}", motherVertices[2].toString());
        Assert.assertEquals("Vertex{id=3, t=Three}", motherVertices[3].toString());
    }
}
