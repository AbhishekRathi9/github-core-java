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

public class ShortestPathUnweighted {

    public static void main(String[] args) {
        Graph graph1 = new AdjacentMatrixGraph(8, Graph.GRAPH_TYPE.DIRECTED);
        graph1.addWeightedEdge(2, 7);
        graph1.addWeightedEdge(3, 0);
        graph1.addWeightedEdge(0, 4);
        graph1.addWeightedEdge(0, 1);
        graph1.addWeightedEdge(2, 1);
        graph1.addWeightedEdge(1, 3);
        graph1.addWeightedEdge(3, 5);
        graph1.addWeightedEdge(6, 3);
        graph1.addWeightedEdge(4, 7);

        Map<Integer, DistanceInfo> distanceInfoMap = shortestPath(graph1, 1, 7);
        printShortestPath(distanceInfoMap, 1, 7);
    }

    private static void printShortestPath(Map<Integer, DistanceInfo> distanceInfoMap, int start, int end) {
        Stack<Integer> stack = new Stack<>();
        stack.add(end);

        int lastVertex = distanceInfoMap.get(end).getLastVertex();
        while(lastVertex!=-1 && lastVertex!=start){
            stack.add(lastVertex);
            lastVertex=distanceInfoMap.get(lastVertex).getLastVertex();
        }
        if(lastVertex==-1){
            System.out.println("no path possible");
        }
        while(!stack.isEmpty()){
            System.out.println(start);
            System.out.println(stack.pop());
        }
    }

    private static Map<Integer, DistanceInfo> shortestPath(Graph graph1, int start, int end) {
        Map<Integer, DistanceInfo> distanceInfoMap = new HashMap<>();
        for (int i = 0; i < graph1.getNumVertices(); i++) {
            distanceInfoMap.put(i, new DistanceInfo(-1, -1));
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        distanceInfoMap.get(start).setDistance(0);
        distanceInfoMap.get(start).setLastVertex(start);

        while (!queue.isEmpty()) {
            Integer currentVertex = queue.poll();
            List<Integer> adjacentVertices = graph1.getAdjacentVertices(currentVertex);
            for (int neighbour : adjacentVertices) {
                if (distanceInfoMap.get(neighbour).getDistance() == -1) {
                    queue.add(neighbour);
                    distanceInfoMap.get(neighbour).setLastVertex(currentVertex);
                    distanceInfoMap.get(neighbour).setDistance(distanceInfoMap.get(currentVertex).getDistance() + 1);
                }
            }
        }
        return distanceInfoMap;
    }
}
