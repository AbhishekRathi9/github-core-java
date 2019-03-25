package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBFT {

    private static int N = 8;
    private int[] visited = new int[N];

    public static void main(String[] args) {

        Graph graph = new AdjacentMatrixGraph(N, Graph.GRAPH_TYPE.DIRECTED);
        graph.addWeightedEdge(1, 0);
        graph.addWeightedEdge(1, 2);
        graph.addWeightedEdge(2, 7);
        graph.addWeightedEdge(2, 4);
        graph.addWeightedEdge(2, 3);
        graph.addWeightedEdge(1, 5);
        graph.addWeightedEdge(5, 6);
        graph.addWeightedEdge(6, 3);
        graph.addWeightedEdge(3, 4);

        GraphBFT bft = new GraphBFT();
        //        for (int i = 0; i < N; i++) {
        //            bft.traverseBFT(i, graph);
        //        }

        for (int i = 0; i < N; i++) {
            bft.traverseDFT(i, graph);
        }
    }

    private void traverseDFT(int currentVertex, Graph graph) {
        if (visited[currentVertex] == 1) {
            return;
        }
        visited[currentVertex] = 1;

        List<Integer> adjacentVertices = graph.getAdjacentVertices(currentVertex);
//
        for (int neighbour : adjacentVertices) {

                traverseDFT(neighbour, graph);

        }
        System.out.println(currentVertex);
    }

    private void traverseBFT(int start, Graph graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        //  visited[start] = 1;
        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            if (visited[vertex] == 0) {
                continue;
            }
            System.out.println(vertex);
            visited[vertex] = 1;
            List<Integer> adjacentVertices = graph.getAdjacentVertices(vertex);
            for (int neighbour : adjacentVertices) {
                if (visited[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }
    }
}
