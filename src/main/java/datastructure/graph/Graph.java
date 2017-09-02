package datastructure.graph;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Graph<T> implements IGraph<T> {

    protected static AtomicInteger vertexIdCounter = new AtomicInteger();
    protected static AtomicInteger edgeIdCounter = new AtomicInteger();
    protected int numberOfNodes;
    protected boolean directed;

    static class Vertex<T> {
        private int id;
        private T t;

        public Vertex(T t) {
            this.id = vertexIdCounter.incrementAndGet();;
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
    }

    static class Edge {
        private int id;
        private Graph.Vertex vertexFrom;
        private Graph.Vertex vertexTo;
        private int weight;

        public Edge(Graph.Vertex vertexFrom, Graph.Vertex vertexTo, int weight) {
            this.id = edgeIdCounter.incrementAndGet();
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
    }
}
