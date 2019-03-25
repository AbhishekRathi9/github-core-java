package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacentMatrixGraph implements Graph {

    private int[][] matrix;
    private Graph.GRAPH_TYPE type;
    private int numVertices = 0;

    public AdjacentMatrixGraph(int numVertices, Graph.GRAPH_TYPE type) {
        this.type = type;
        matrix = new int[numVertices][numVertices];
        this.numVertices = numVertices;
    }

    public static void main(String[] args) {
        Graph graph = new AdjacentMatrixGraph(4, Graph.GRAPH_TYPE.DIRECTED);
    }

    @Override
    public void addWeightedEdge(int v1, int v2, int weight) {
        if (v1 < 0 || v2 < 0 || v1 >= numVertices || v2 >= numVertices) {
            throw new IllegalArgumentException("Vertices are not valid");
        }
        matrix[v1][v2] = weight;
        if (type.equals(Graph.GRAPH_TYPE.UNDIRECTED)) {
            matrix[v2][v1] = weight;
        }
    }

    @Override
    public int getWeightedEdge(int currentVertex, int vertex) {
        return matrix[currentVertex][vertex];
    }

    @Override
    public List<Integer> getAdjacentVertices(int vertex) {
        if (vertex < 0 || vertex >= numVertices) {
            throw new IllegalArgumentException("Vertices are not valid");
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            if (matrix[vertex][i] != 0) {
                list.add(i);
            }
            Collections.sort(list);
        }
        return list;
    }

    @Override
    public void addWeightedEdge(int v1, int v2) {
        if (v1 < 0 || v2 < 0 || v1 >= numVertices || v2 >= numVertices) {
            throw new IllegalArgumentException("Vertices are not valid");
        }
        matrix[v1][v2] = 1;
        if (type.equals(Graph.GRAPH_TYPE.UNDIRECTED)) {
            matrix[v2][v1] = 1;
        }
    }

    @Override
    public int getNumVertices() {
        return numVertices;
    }

    @Override
    public int getDegree(int vertex) {
        if (vertex < 0 || vertex >= numVertices) {
            throw new IllegalArgumentException("illegal vertex");
        }
        int degree = 0;
        for (int i = 0; i < numVertices; i++) {
            if (matrix[i][vertex] != 0) {
                degree++;
            }
        }
        return degree;
    }
}
