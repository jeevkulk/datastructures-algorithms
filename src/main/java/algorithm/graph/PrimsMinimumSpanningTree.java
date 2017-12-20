package algorithm.graph;

import datastructure.graph.AdjacencyLinkedListGraph;
import datastructure.graph.AdjacencyMatrixGraph;
import datastructure.graph.Graph;
import datastructure.graph.IGraph;
import datastructure.tree.binary.MinimumBinaryHeap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.security.provider.certpath.Vertex;

import java.util.*;

public class PrimsMinimumSpanningTree {

    private Logger logger = LogManager.getLogger(PrimsMinimumSpanningTree.class);

    /**
     * We are starting with one of the mother vertex - mother vertex is the vertex from which
     * all other vertices are reachable
     */
    private IGraph<Integer> graph = null;
    private Map<Graph.Vertex, HeapMap> heapMapVertexMap = null;
    private MinimumBinaryHeap<HeapMap> minimumBinaryHeap = null;

    /**
     * This map is redundant in this case as I am storing the weights, vertexFrom and vertexTo in edge
     * unlike what is traditionally done. Traditionally, this would get the edge for the vertex that
     * can be reached with minimum heapWeight
     */
    private Map<Graph.Vertex, Graph.Edge> vertexEdgeMap = new HashMap<>();
    private List<Graph.Edge> mstEdges = new ArrayList<>();
    private Set<Graph.Vertex> verticesConsideredSet = new HashSet<>();

    public PrimsMinimumSpanningTree(IGraph<Integer> graph) {
        this.graph = graph;
        minimumBinaryHeap = new MinimumBinaryHeap<>(HeapMap.class);
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

            while (minimumBinaryHeap.size() > 0) {
                HeapMap heapMap = minimumBinaryHeap.poll();
                verticesConsideredSet.add(heapMap.getVertex());
                Graph.Edge[] linkedEdges = ((AdjacencyMatrixGraph) graph).getLinkedEdges(heapMap.getVertex());
                int minimumHeapWeight = Integer.MAX_VALUE;
                Graph.Edge edgeWithMinimumWeight = null;
                Graph.Vertex closestVertex = null;
                for (Graph.Edge edge : linkedEdges) {
                    if (edge != null && !verticesConsideredSet.contains(edge.getVertexTo())) {
                        // Modify the weight in the heap - so that it gets sorted
                        minimumBinaryHeap.modify(heapMapVertexMap.get(edge.getVertexTo()), new HeapMap(edge.getVertexTo(), edge.getWeight()));
                        // Add the vertex to map - to map the vertex to edge
                        vertexEdgeMap.put(edge.getVertexTo(), edge);
                        if (edge.getWeight() < minimumHeapWeight) {
                            minimumHeapWeight = edge.getWeight();
                            edgeWithMinimumWeight = edge;
                            closestVertex = edge.getVertexTo();
                        }
                    }
                }
                if (closestVertex != null) {
                    //mstEdges.add(edgeWithMinimumWeight); // Had we used this, vertexEdgeMap would have been redundant
                    mstEdges.add(vertexEdgeMap.get(closestVertex)); // Traditional way
                }
            }
        } else if (graph instanceof AdjacencyLinkedListGraph) {
            throw new IllegalArgumentException();
        }
        for (Graph.Edge mstEdge : mstEdges) {
            System.out.println(mstEdge.toString());
        }
    }

    private void initializeVerticesHeap(Graph.Vertex[] vertices, Graph.Vertex motherVertex) {
        HeapMap heapMap = null;
        heapMapVertexMap = new HashMap<>();
        for (int i = 0; i < vertices.length; i++) {
            if (motherVertex.getId() == vertices[i].getId()) {
                heapMap = new HeapMap(vertices[i], 0);
            } else {
                heapMap = new HeapMap(vertices[i], Integer.MAX_VALUE);
            }
            heapMapVertexMap.put(vertices[i], heapMap);
            minimumBinaryHeap.add(heapMap);
        }
    }

    private class HeapMap implements Comparable<HeapMap> {
        private Graph.Vertex vertex;
        private int heapWeight;

        public HeapMap(Graph.Vertex vertex, int heapWeight) {
            this.vertex = vertex;
            this.heapWeight = heapWeight;
        }

        public Graph.Vertex getVertex() {
            return vertex;
        }

        public void setVertex(Graph.Vertex vertex) {
            this.vertex = vertex;
        }

        public int getHeapWeight() {
            return heapWeight;
        }

        public void setHeapWeight(int heapWeight) {
            this.heapWeight = heapWeight;
        }

        @Override
        public int compareTo(HeapMap heapMap) {
            return (heapWeight > heapMap.getHeapWeight()) ? 1 : (heapWeight < (int)heapMap.getHeapWeight()) ? -1 : 0;
        }

        @Override
        public int hashCode() {
            return vertex.getId();
        }

        @Override
        public boolean equals(Object obj) {
            HeapMap heapMap = (HeapMap)obj;
            return vertex.getId() == heapMap.vertex.getId();
        }
    }
}
