package datastructure.graph;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicInteger;

public class AdjacencyMatrixGraph<T> extends Graph<T> {

    private Logger logger = LogManager.getLogger(AdjacencyMatrixGraph.class);
    /**
     * Internal storage structure for ADJACENCY_MATRIX_GRAPH
     */
    protected AtomicInteger vertexIdCounter = new AtomicInteger(0);
    protected AtomicInteger edgeIdCounter = new AtomicInteger(0);
    private Graph<T>.Edge[][] edgeArr;

    /**
     * Constructor
     * @param numberOfVertices
     * @param directed
     */
    public AdjacencyMatrixGraph(int numberOfVertices, boolean directed) {
        super();
        this.numberOfVertices = numberOfVertices;
        this.directed = directed;
        edgeArr = new Graph.Edge[numberOfVertices][numberOfVertices];
    }

    @Override
    protected int getVertexId() {
        return vertexIdCounter.getAndIncrement();
    }

    @Override
    protected int getEdgeId() {
        return edgeIdCounter.getAndIncrement();
    }


    /**
     * Creates a vertex
     * @param t
     * @return
     */
    @Override
    public Vertex<T> createVertex(T t) {
        Graph.Vertex vertex = new Graph.Vertex(t);
        return vertex;
    }

    /**
     * Creates edges
     * @param vertexFrom
     * @param vertexTo
     * @param weight
     */
    @Override
    public void addEdge(Vertex<T> vertexFrom, Vertex<T> vertexTo, int weight) {
        Edge edge = new Edge(vertexFrom, vertexTo, weight);
        int i = vertexFrom.getId();
        int j = vertexTo.getId();
        edgeArr[i][j] = edge;
        if (!directed) {
            edgeArr[j][i] = edge;
        }
    }

    @Override
    public Vertex<T>[] getMotherVertices() {
        return null;
    }

    /**
     * Gets linked edges
     * @param vertex
     * @return
     */
    @Override
    public Edge[] getLinkedEdges(final Vertex<T> vertex) {
        int vertexId = vertex.getId();
        Edge[] linkedEdgeArr = new Graph.Edge[this.numberOfVertices];
        for (int i = 0; i < edgeArr[vertexId].length; i++) {
            if (edgeArr[vertexId][i] != null)
                linkedEdgeArr[i] = edgeArr[vertexId][i];
        }
        return linkedEdgeArr;
    }

    /**
     * Gets Linked vertices
     * @param vertex
     * @return
     */
    @Override
    public Vertex[] getLinkedVertices(final Vertex<T> vertex) {
        int vertexId = vertex.getId();
        Graph.Edge[] linkedEdgeArr = new Graph.Edge[this.numberOfVertices];
        Vertex[] linkedVerticesArr = new Vertex[this.numberOfVertices];
        for (int i = 0; i < edgeArr[vertexId].length; i++) {
            if (edgeArr[vertexId][i] != null) {
                linkedVerticesArr[i] = edgeArr[vertexId][i].getVertexTo();
            }
        }
        return linkedVerticesArr;
    }


    public void doDepthFirstTraversal() {
        Graph<T>.Edge[][] localEdgeArr = edgeArr;

        boolean[][] visited = new boolean[localEdgeArr.length][localEdgeArr.length];
        /*for (int i = 0; i < localEdgeArr.length; i++) {
            for (int j = 0; j < localEdgeArr[i].length; j++) {
                visited[i][j] = false;
            }
        }*/
    }

    /**
     * Overridden toString method
     * @return
     */
    @Override
    public String toString() {
        StringBuilder cumulativeStringBuilder = new StringBuilder();
        for (int i = 0; i < edgeArr.length; i++) {
            StringBuilder edgeStringBuilder = new StringBuilder();
            for (int j = 0; j < edgeArr.length; j++) {
                if (edgeArr[i][j] != null) {
                    edgeStringBuilder.append(edgeArr[i][j].getWeight() + " ");
                } else {
                    edgeStringBuilder.append("x ");
                }
            }
            cumulativeStringBuilder.append(edgeStringBuilder);
            logger.info(edgeStringBuilder.toString());
        }
        return cumulativeStringBuilder.toString();
    }
}
