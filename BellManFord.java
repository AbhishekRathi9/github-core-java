package graph;

import graph.AdjacentMatrixGraph;
import graph.DistanceInfo;
import graph.Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BellManFord {

    public static void main(String[] args) {
        Graph graph1 = new AdjacentMatrixGraph(8, Graph.GRAPH_TYPE.DIRECTED);
        graph1.addWeightedEdge(2, 7, 4);
        graph1.addWeightedEdge(0, 3, 23);
        graph1.addWeightedEdge(0, 4, 23);
        graph1.addWeightedEdge(0, 1, 1);
        graph1.addWeightedEdge(2, 1, 3);
        graph1.addWeightedEdge(1, 3, 2);
        graph1.addWeightedEdge(3, 5, 1);
        graph1.addWeightedEdge(3, 6, 3);
        graph1.addWeightedEdge(4, 7, 2);
        graph1.addWeightedEdge(7, 5, 4);

        Map<Integer, DistanceInfo> distanceInfoMap = applyLogic(graph1, 0, 5);
        Stack<Integer> stack = new Stack<>();
        stack.add(5);
        int lastVertex = distanceInfoMap.get(5).getLastVertex();
        while (lastVertex != -1 && lastVertex != 0) {
            stack.add(lastVertex);
            lastVertex = distanceInfoMap.get(lastVertex).getLastVertex();
        }
        System.out.println(0);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static Map<Integer, DistanceInfo> applyLogic(Graph graph1, int start, int end) {
        Map<Integer, DistanceInfo> distanceInfoMap = new HashMap<>();

        for (int i = 0; i < graph1.getNumVertices(); i++) {
            distanceInfoMap.put(i, new DistanceInfo(10000, -1));
        }

        distanceInfoMap.get(start).setDistance(0);
        distanceInfoMap.get(start).setLastVertex(start);
        for (int i = 0; i < graph1.getNumVertices(); i++) {
            relaxEdges(graph1, distanceInfoMap, 0, 5);
        }
        checkNegativeCycle(graph1, distanceInfoMap);
        return distanceInfoMap;
    }

    private static void checkNegativeCycle(Graph graph1, Map<Integer, DistanceInfo> distanceInfoMap) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph1.getNumVertices(); i++) {
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            Integer currentVertex = queue.poll();
            List<Integer> adjacentVertices = graph1.getAdjacentVertices(currentVertex);
            for (int neighbour : adjacentVertices) {
                int newDistance = distanceInfoMap.get(currentVertex).getDistance() + graph1.getWeightedEdge(currentVertex, neighbour);
                int existingDistance = distanceInfoMap.get(neighbour).getDistance();
                if (newDistance < existingDistance) {
                    // queue.add(neighbour);
                    throw new IllegalArgumentException("graph has negative cycle");
                }
            }
        }
    }

    private static Map<Integer, DistanceInfo> relaxEdges(Graph graph1, Map<Integer, DistanceInfo> distanceInfoMap, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph1.getNumVertices(); i++) {
            queue.add(i);
        }
        // int[] visited = new int[graph1.getNumVertices()];
        while (!queue.isEmpty()) {
            Integer currentVertex = queue.poll();
            //            if (visited[currentVertex] == 1) {
            //                continue;
            //            }
            //            visited[currentVertex] = 1;
            List<Integer> adjacentVertices = graph1.getAdjacentVertices(currentVertex);
            for (int neighbour : adjacentVertices) {
                int newDistance = distanceInfoMap.get(currentVertex).getDistance() + graph1.getWeightedEdge(currentVertex, neighbour);
                int existingDistance = distanceInfoMap.get(neighbour).getDistance();
                if (newDistance < existingDistance) {
                    // queue.add(neighbour);
                    distanceInfoMap.get(neighbour).setLastVertex(currentVertex);
                    distanceInfoMap.get(neighbour).setDistance(newDistance);
                }
            }
        }

        return distanceInfoMap;
    }
}
