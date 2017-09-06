package datastructure.graph;

public interface IGraph<T> {

    public Graph<T>.Vertex<T> createVertex(T t);

    public void addEdge(Graph<T>.Vertex<T> vertexFrom, Graph<T>.Vertex<T> vertexTo, int weight);

    public Graph<T>.Vertex<T>[][] getMotherVertices();

    public Graph<T>.Edge[] getLinkedEdges(Graph<T>.Vertex<T> vertex);

    public Graph<T>.Vertex<T>[] getLinkedVertices(Graph<T>.Vertex<T> vertex);

}
