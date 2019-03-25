package graph;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdjacentListGraph implements Graph {

    private int numVertices;
    private Graph.GRAPH_TYPE type;
    private List<Node> vertices = new ArrayList<>();

    public AdjacentListGraph(int numVertices, Graph.GRAPH_TYPE type) {
        this.numVertices = numVertices;
        this.type = type;
        for (int i = 0; i < numVertices; i++) {
            vertices.add(new Node(i));
        }
    }

    @Override
    public void addWeightedEdge(int v1, int v2, int weight) {

    }

    @Override
    public int getWeightedEdge(int currentVertex, int vertex) {
        return 0;
    }

    @Override
    public List<Integer> getAdjacentVertices(int vertex) {
        return vertices.get(vertex).getAdjacentNodes();
    }

    @Override
    public void addWeightedEdge(int v1, int v2) {
        if (v1 >= numVertices || v2 >= numVertices || v1 < 0 || v2 < 0) {
            throw new IllegalArgumentException("Vertex number is not valid");
        }
        vertices.get(v1).getAdjacentNodes().add(v2);
        if (type == Graph.GRAPH_TYPE.UNDIRECTED) {
            vertices.get(v2).getAdjacentNodes().add(v1);
        }
    }

    @Override
    public int getNumVertices() {
        return 0;
    }

    @Override
    public int getDegree(int vertex) {
        return 0;
    }

    static class Node {

        private int vertex;
        private List<Integer> adjacentNodes;

        public Node(int vertex) {
            this.vertex = vertex;
        }

        public int getVertex() {
            return vertex;
        }

        public void setVertex(int vertex) {
            this.vertex = vertex;
        }

        public List<Integer> getAdjacentNodes() {
            return adjacentNodes;
        }

        public void setAdjacentNodes(List<Integer> adjacentNodes) {
            this.adjacentNodes = adjacentNodes;
        }
    }
}


