package datastructure.graph;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicInteger;

public class AdjacencyLinkedListGraph<T> extends Graph<T> {

    private Logger logger = LogManager.getLogger(AdjacencyLinkedListGraph.class);

    protected AtomicInteger vertexIdCounter = new AtomicInteger(0);
    protected AtomicInteger edgeIdCounter = new AtomicInteger(0);
    private int INITIAL_SIZE = 1 << 4;
    private float LOAD_FACTOR = 0.75f;

    /**
     * Internal storage structure for ADJACENCY_LINKED_LIST
     */
    private Vertex[] verticesArr;

    public AdjacencyLinkedListGraph(int numberOfVertices, boolean directed) {
        this.numberOfVertices = numberOfVertices;
        this.directed = directed;
        verticesArr = new Vertex[numberOfVertices];
    }

    @Override
    protected int getVertexId() {
        return vertexIdCounter.getAndIncrement();
    }

    @Override
    protected int getEdgeId() {
        return edgeIdCounter.getAndIncrement();
    }

    @Override
    public Vertex<T> createVertex(T t) {
        Vertex<T> vertex = new Vertex<>(t);
        for (int i = 0; i < verticesArr.length; i++) {
            if (verticesArr[i] == null) {
                verticesArr[i] = vertex;
                break;
            }
        }
        return vertex;
    }

    @Override
    public void addEdge(Graph<T>.Vertex<T> vertexFrom, Graph<T>.Vertex<T> vertexTo, int weight) {
        Vertex<T> linkedListVertexFrom = (Vertex<T>) vertexFrom;
        Vertex<T> linkedListVertexTo = (Vertex<T>) vertexTo;
        Edge edgeFromTo = new Edge(linkedListVertexFrom, linkedListVertexTo, weight);
        addEdgeToVertex(linkedListVertexFrom, edgeFromTo);
        if (!directed) {
            Edge edgeToFrom = new Edge(linkedListVertexTo, linkedListVertexFrom, weight);
            addEdgeToVertex(linkedListVertexTo, edgeToFrom);
        }
    }

    private void addEdgeToVertex(Vertex<T> vertex, Edge edge) {
        int i = 0;
        Edge[] edgeArr = vertex.getEdgeArr();
        if (edgeArr == null) {
            edgeArr = new Graph.Edge[INITIAL_SIZE];
        }
        for (i = 0; i < edgeArr.length; i++) {
            if (edgeArr[i] == null) {
                edgeArr[i] = edge;
                break;
            }
        }
        vertex.setEdgeArr(edgeArr);
        if (i > LOAD_FACTOR * edgeArr.length) {
            int size = edgeArr.length << 1;
            Graph.Edge[] newEdgeArr = new Graph.Edge[size];

            for (i = 0; i < edgeArr.length; i++) {
                if (edgeArr[i] == null) {
                    newEdgeArr[i] = edgeArr[i];
                    break;
                }
            }
            vertex.setEdgeArr(newEdgeArr);
        }
    }

    @Override
    public Vertex<T> getMotherVertex() {
        return null;
    }

    @Override
    public Edge[] getLinkedEdges(Graph<T>.Vertex<T> vertex) {
        Vertex<T> linkedVertex = (Vertex<T>) vertex;
        Edge[] linkedEdgeArr = linkedVertex.getEdgeArr();
        return linkedEdgeArr;
    }

    @Override
    public Vertex<T>[] getLinkedVertices(Graph<T>.Vertex<T> vertex) {
        Vertex<T> linkedVertex = (Vertex<T>) vertex;
        Edge[] linkedEdgeArr = linkedVertex.getEdgeArr();
        Vertex<T>[] linkedVertexArr = new Vertex[numberOfVertices];
        for (int i = 0; i < linkedEdgeArr.length; i++) {
            if (linkedEdgeArr[i] != null)
                linkedVertexArr[i] = (Vertex) linkedEdgeArr[i].getVertexTo();
        }
        return linkedVertexArr;
    }

    @Override
    public String toString() {
        StringBuilder cumulativeStringBuilder = new StringBuilder();
        for (int i = 0; i < verticesArr.length; i++) {
            StringBuilder vertexStringBuilder = new StringBuilder();
            Vertex vertex = (Vertex)verticesArr[i];
            if (vertex != null) {
                vertexStringBuilder.append(vertex.getT() + "->");
                Edge[] edgeArr = vertex.getEdgeArr();
                if (edgeArr != null) {
                    for (int j = 0; j < edgeArr.length; j++) {
                        if (edgeArr[j] != null) {
                            vertexStringBuilder.append(edgeArr[j].getVertexTo().getT()+" ");
                        }
                    }
                }
            }
            logger.info(vertexStringBuilder.toString());
            cumulativeStringBuilder.append(vertexStringBuilder);
        }
        return cumulativeStringBuilder.toString();
    }

    class Vertex<T> extends Graph<T>.Vertex<T> {
        private Edge[] edgeArr;

        public Vertex(T t) {
            super(t);
        }

        public Edge[] getEdgeArr() {
            return edgeArr;
        }

        public void setEdgeArr(Edge[] edgeArr) {
            this.edgeArr = edgeArr;
        }

    }
}
