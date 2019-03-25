import graph.AdjacentMatrixGraph;
import graph.Graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiStageGraph {

    public static void main(String[] args) {

        Graph graph = new AdjacentMatrixGraph(8, Graph.GRAPH_TYPE.DIRECTED);
        graph.addWeightedEdge(0, 1, 3);
        graph.addWeightedEdge(0, 2, 2);
        graph.addWeightedEdge(0, 3, 4);
        graph.addWeightedEdge(1, 4, 1);
        graph.addWeightedEdge(1, 5, 9);
        graph.addWeightedEdge(1, 6, 6);
        graph.addWeightedEdge(2, 4, 10);
        graph.addWeightedEdge(2, 5, 8);
        graph.addWeightedEdge(3, 6, 5);
        graph.addWeightedEdge(3, 5, 7);
        graph.addWeightedEdge(4, 7, 2);
        graph.addWeightedEdge(5, 7, 1);
        graph.addWeightedEdge(6, 7, 3);

        logic(graph, 0, 7);
    }

    private static void logic(Graph graph, int source, int destination) {
        Map<Integer, DistanceInfo> distanceInfoMap = new HashMap<>();
        for (int i = 0; i < graph.getNumVertices(); i++) {
            distanceInfoMap.put(i, new DistanceInfo(-1, -1));
        }

        distanceInfoMap.get(destination).setDistance(0);
        distanceInfoMap.get(destination).setLastVertex(source);

        for (int currentVertex = graph.getNumVertices() - 2; currentVertex >= 0; currentVertex--) {
            List<Integer> adjacentVertices = graph.getAdjacentVertices(currentVertex);
            int minDistance = Integer.MAX_VALUE;
            int lastVertex = -1;
            for (int neighbour : adjacentVertices) {
                int weightedEdge = graph.getWeightedEdge(currentVertex,neighbour);
                int distance = distanceInfoMap.get(neighbour).getDistance();
                if (minDistance > weightedEdge + distance) {
                    minDistance = weightedEdge + distance;
                    lastVertex = neighbour;
                }
            }
            distanceInfoMap.put(currentVertex, new DistanceInfo(minDistance, lastVertex));
        }

        int lastVertex=source;
        while(lastVertex != destination){
            System.out.println(lastVertex);;
            lastVertex=distanceInfoMap.get(lastVertex).getLastVertex();
        }
    }

    static class DistanceInfo {

        private int distance;
        private int lastVertex;

        public DistanceInfo(int distance, int lastVertex) {
            this.distance = distance;
            this.lastVertex = lastVertex;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public int getLastVertex() {
            return lastVertex;
        }

        public void setLastVertex(int lastVertex) {
            this.lastVertex = lastVertex;
        }
    }
}
