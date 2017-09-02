package datastructure.graph;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdjacencyLinkedListGraph<T> extends Graph<T> {

    private Logger logger = LogManager.getLogger(AdjacencyLinkedListGraph.class);
    private int INITIAL_SIZE = 1 << 4;
    private float LOAD_FACTOR = 0.75f;

    /**
     * Internal storage structure for ADJACENCY_LINKED_LIST
     */
    private Graph.Vertex[] verticesArr;

    public AdjacencyLinkedListGraph(int numberOfNodes, boolean directed) {
        this.numberOfNodes = numberOfNodes;
        this.directed = directed;
        verticesArr = new Vertex[numberOfNodes];
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
    public void addEdge(Graph.Vertex<T> vertexFrom, Graph.Vertex<T> vertexTo, int weight) {
        Vertex linkedListVertexFrom = (Vertex)vertexFrom;
        Vertex linkedListVertexTo = (Vertex)vertexTo;
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
            edgeArr = new Edge[INITIAL_SIZE];
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
            Edge[] newEdgeArr = new Edge[size];

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
    public String toString() {
        StringBuilder cumulativeStringBuilder = new StringBuilder();
        for (int i = 0; i < verticesArr.length; i++) {
            StringBuilder vertextStringBuilder = new StringBuilder();
            Vertex vertex = (Vertex)verticesArr[i];
            if (vertex != null) {
                vertextStringBuilder.append(vertex.getId() + "->");
                Edge[] edgeArr = vertex.getEdgeArr();
                if (edgeArr != null) {
                    for (int j = 0; j < edgeArr.length; j++) {
                        if (edgeArr[j] != null) {
                            vertextStringBuilder.append(edgeArr[j].getVertexTo().getId()+" ");
                        }
                    }
                }
            }
            System.out.println(vertextStringBuilder.toString());
            cumulativeStringBuilder.append(vertextStringBuilder);
            vertextStringBuilder = new StringBuilder();
        }
        return cumulativeStringBuilder.toString();
    }

    static class Vertex<T> extends Graph.Vertex<T> {
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
