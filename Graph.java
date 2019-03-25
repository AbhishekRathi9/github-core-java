package graph;

import java.util.List;

public interface Graph {

    void addWeightedEdge(int v1, int v2, int weight);

    int getWeightedEdge(int currentVertex, int vertex);

    enum GRAPH_TYPE {
        DIRECTED,
        UNDIRECTED
    }

    List<Integer> getAdjacentVertices(int vertex);

    void addWeightedEdge(int v1, int v2);

    int getNumVertices();

    int getDegree(int vertex);
}
