package algorithm.graph;

import datastructure.graph.AdjacencyLinkedListGraph;
import datastructure.graph.AdjacencyMatrixGraph;
import datastructure.graph.Graph;
import datastructure.graph.IGraph;
import datastructure.tree.binary.MinimumBinaryHeap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimsMinimumSpanningTree {

    private Logger logger = LogManager.getLogger(PrimsMinimumSpanningTree.class);

    /**
     * We are starting with one of the mother vertex - mother vertex is the vertex from which
     * all other vertices are reachable
     */
    private IGraph<Integer> graph = null;
    private MinimumBinaryHeap<HeapMap> verticesHeap = null;

    /**
     * This map is redundant in this case as I am storing the weights, vertexFrom and vertexTo in edge
     * unlike what is traditionally done. Traditionally, this would get the edge for the vertex that
     * can be reached with minimum weight
     */
    private Map<Graph.Vertex, Graph.Edge> vertexEdgeMap = new HashMap<>();
    private List<Graph.Edge> mstEdges = new ArrayList<>();

    public PrimsMinimumSpanningTree(IGraph<Integer> graph) {
        this.graph = graph;
        verticesHeap = new MinimumBinaryHeap<>(Integer.class);
    }

    public void findMinimumSpanningTree() {
        if (graph == null) {
            throw new IllegalStateException();
        }
        if (graph instanceof AdjacencyMatrixGraph) {
            graph = (AdjacencyMatrixGraph)graph;

            Graph.Vertex[] motherVertices =  graph.getMotherVertices();
            if (motherVertices == null) {
                throw new IllegalStateException();
            }
            initializeVerticesHeap(((AdjacencyMatrixGraph) graph).getAllVertices(), motherVertices[0]);

            while (verticesHeap.peek() != null) {
                HeapMap heapMap = verticesHeap.poll();
                Graph.Edge[] linkedEdges = ((AdjacencyMatrixGraph) graph).getLinkedEdges(heapMap.getVertex());
                int minimumWeight = Integer.MAX_VALUE;
                Graph.Edge edgeWithMinimumWeight = null;
                Graph.Vertex closestVertex = null;
                for (Graph.Edge edge : linkedEdges) {
                    verticesHeap.modify(edge.getVertexTo().getId(), new HeapMap(edge.getVertexTo(), minimumWeight));
                    vertexEdgeMap.put(edge.getVertexTo(), edge);
                    if (edge.getWeight() < minimumWeight) {
                        minimumWeight = edge.getWeight();
                        edgeWithMinimumWeight = edge;
                        closestVertex = edge.getVertexTo();
                    }
                }
                //mstEdges.add(edgeWithMinimumWeight); // Had we used this vertexEdgeMap would have been redundant
                mstEdges.add(vertexEdgeMap.get(closestVertex)); // Traditional way
            }
        } else if (graph instanceof AdjacencyLinkedListGraph) {
            throw new IllegalArgumentException();
        }
    }

    private void initializeVerticesHeap(Graph.Vertex[] vertices, Graph.Vertex motherVertex) {
        for (int i = 0; i < vertices.length; i++) {
            if (motherVertex.getId() == vertices[i].getId())
                verticesHeap.add(new HeapMap(vertices[i], 0));
            else
                verticesHeap.add(new HeapMap(vertices[i], Integer.MAX_VALUE));
        }
    }

    private class HeapMap implements Comparable<HeapMap> {
        private Graph.Vertex vertex;
        private int weight;

        public HeapMap(Graph.Vertex vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public Graph.Vertex getVertex() {
            return vertex;
        }

        public void setVertex(Graph.Vertex vertex) {
            this.vertex = vertex;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public int compareTo(HeapMap heapMap) {
            return (weight > heapMap.getWeight()) ? 1 : (weight < (int)heapMap.getWeight()) ? -1 : 0;
        }
    }
}
