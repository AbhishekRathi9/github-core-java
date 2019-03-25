package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ToplogicalSort {

    public static void main(String[] args) {
        Graph graph = new AdjacentMatrixGraph(8, Graph.GRAPH_TYPE.DIRECTED);
        graph.addWeightedEdge(2, 7);
        graph.addWeightedEdge(0, 3);
        graph.addWeightedEdge(0, 4);
        graph.addWeightedEdge(0, 1);
        graph.addWeightedEdge(2, 1);
        graph.addWeightedEdge(1, 3);
        graph.addWeightedEdge(3, 5);
        graph.addWeightedEdge(3, 6);
        graph.addWeightedEdge(4, 7);

        ToplogicalSort top = new ToplogicalSort();
        top.sort(graph);
    }

    public List<Integer> sort(Graph graph) {
        Map<Integer, Integer> degreeMap = new HashMap<>();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.getNumVertices(); i++) {
            int degree = graph.getDegree(i);
            degreeMap.put(i, degree);
            if (degree == 0) {
                queue.add(i);
            }
        }

        List<Integer> sortedList = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer vertex = queue.pollLast();
            sortedList.add(vertex);

            List<Integer> adjacentVertices = graph.getAdjacentVertices(vertex);
            for (int neighbour : adjacentVertices) {
                // int degree = graph.getDegree(neighbour);
                degreeMap.put(neighbour, degreeMap.get(neighbour) - 1);
                if (degreeMap.get(neighbour) == 0) {
                    queue.add(neighbour);
                }
            }
        }
        if (sortedList.size() != graph.getNumVertices()) {
            throw new RuntimeException("The graph.Graph had a cycle!");
        }
        System.out.println(sortedList);
        return sortedList;
    }
}


