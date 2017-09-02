package datastructure.graph;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdjacencyMatrixGraph<T> extends Graph<T> {

    private Logger logger = LogManager.getLogger(AdjacencyMatrixGraph.class);
    /**
     * Internal storage structure for ADJACENCY_MATRIX
     */
    private Edge[][] edgeArr;

    public AdjacencyMatrixGraph(int numberOfNodes, boolean directed) {
        this.numberOfNodes = numberOfNodes;
        this.directed = directed;
        edgeArr = new Edge[numberOfNodes][numberOfNodes];
    }

    @Override
    public Vertex<T> createVertex(T t) {
        Vertex<T> vertex = new Vertex<>(t);
        return vertex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < edgeArr.length; i++) {
            for (int j = 0; j < edgeArr.length; j++) {
                if (edgeArr[i][j] != null) {
                    System.out.print(edgeArr[i][j].getWeight()+ " ");
                    sb.append(edgeArr[i][j].getWeight() + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println("");
        }
        return sb.toString();
    }

    @Override
    public void addEdge(Vertex<T> vertexFrom, Vertex<T> vertexTo, int weight) {
        Edge edge = new Edge(vertexFrom, vertexTo, weight);
        int i = vertexFrom.getId();
        int j = vertexTo.getId();
        edgeArr[i-1][j-1] = edge;
        if (!directed) {
            edgeArr[j-1][i-1] = edge;
        }
    }
}
