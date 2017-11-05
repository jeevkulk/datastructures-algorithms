package datastructure.graph;

public abstract class Graph<T> implements IGraph<T> {

    protected int numberOfVertices;
    protected boolean directed;

    public class Vertex<T> {
        private int id;
        private T t;

        public Vertex(T t) {
            this.id = getVertexId();
            this.t = t;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "id=" + id +
                    ", t=" + t +
                    '}';
        }
    }

    public class Edge {
        private int id;
        private Graph.Vertex vertexFrom;
        private Graph.Vertex vertexTo;
        private int weight;

        public Edge(Graph.Vertex vertexFrom, Graph.Vertex vertexTo, int weight) {
            this.id = getEdgeId();
            this.vertexFrom = vertexFrom;
            this.vertexTo = vertexTo;
            this.weight = weight;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Graph.Vertex getVertexFrom() {
            return vertexFrom;
        }

        public void setVertexFrom(Graph.Vertex vertexFrom) {
            this.vertexFrom = vertexFrom;
        }

        public Graph.Vertex getVertexTo() {
            return vertexTo;
        }

        public void setVertexTo(Graph.Vertex vertexTo) {
            this.vertexTo = vertexTo;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "id=" + id +
                    ", vertexFrom=" + vertexFrom +
                    ", vertexTo=" + vertexTo +
                    ", weight=" + weight +
                    '}';
        }
    }

    protected abstract int getVertexId();

    protected abstract int getEdgeId();
}
