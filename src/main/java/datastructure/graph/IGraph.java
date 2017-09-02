package datastructure.graph;

public interface IGraph<T> {

    public Graph.Vertex<T> createVertex(T t);

    public void addEdge(Graph.Vertex<T> vertexFrom, Graph.Vertex<T> vertexTo, int weightage);
}
