package graph;

import graph.AdjacentMatrixGraph;
import graph.DistanceInfo;
import graph.Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Prim {

    public static void main(String[] args) {
        Graph graph1 = new AdjacentMatrixGraph(8, Graph.GRAPH_TYPE.DIRECTED);
        //        graph1.addWeightedEdge(2, 7, 4);
        //        graph1.addWeightedEdge(0, 3, 23);
        //        graph1.addWeightedEdge(0, 4, 23);
        //        graph1.addWeightedEdge(0, 1, 1);
        //        graph1.addWeightedEdge(2, 1, 3);
        //        graph1.addWeightedEdge(1, 3, 2);
        //        graph1.addWeightedEdge(3, 5, 1);
        //        graph1.addWeightedEdge(3, 6, 3);
        //        graph1.addWeightedEdge(4, 7, 2);
        //        graph1.addWeightedEdge(7, 5, 4);

        graph1.addWeightedEdge(0, 1, 1);
        graph1.addWeightedEdge(0, 2, 2);
        graph1.addWeightedEdge(2, 3, 3);
        graph1.addWeightedEdge(3, 1, 2);
        graph1.addWeightedEdge(3, 4, 7);
        graph1.addWeightedEdge(1, 4, 8);

        List<String> shortestPath = findShortestPath(graph1);
        System.out.println(shortestPath);
    }

    private static List<String> findShortestPath(Graph graph1) {

        Map<Integer, DistanceInfo> distanceInfoMap = new HashMap<>();
        for (int i = 0; i < graph1.getNumVertices(); i++) {
            distanceInfoMap.put(i, new DistanceInfo(Integer.MAX_VALUE, -1));
        }

        PriorityQueue<VertexInfo> queue = new PriorityQueue<>(new Comparator<VertexInfo>() {
            @Override
            public int compare(VertexInfo o1, VertexInfo o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        });

        Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();
        distanceInfoMap.get(0).setDistance(0);
        distanceInfoMap.get(0).setLastVertex(0);
        vertexInfoMap.put(0, new VertexInfo(0, 0));
        queue.add(vertexInfoMap.get(0));
        int[] visited = new int[graph1.getNumVertices()];
        List<String> shortestPath = new ArrayList<>();
       // shortestPath.add("0");
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll().getVertex();
            if (visited[currentVertex] == 1) {
                continue;
            }
            visited[currentVertex] = 1;
            shortestPath.add(currentVertex+"");
            List<Integer> adjacentVertices = graph1.getAdjacentVertices(currentVertex);
            for (int neighbour : adjacentVertices) {
                if (visited[neighbour] == 1) {
                    continue;
                }
                int newDistance = graph1.getWeightedEdge(currentVertex, neighbour);
                int currentDistance = distanceInfoMap.get(neighbour).getDistance();
                if (newDistance < currentDistance) {
                    distanceInfoMap.get(neighbour).setDistance(newDistance);
                    distanceInfoMap.get(neighbour).setLastVertex(currentVertex);
                    vertexInfoMap.put(neighbour, new VertexInfo(neighbour, newDistance));
                   // shortestPath.add(String.valueOf(currentVertex).concat(String.valueOf(neighbour)));
                    queue.add(vertexInfoMap.get(neighbour));
                }
            }
        }
        return shortestPath;
    }

    static class VertexInfo {

        private int vertex;
        private int weight;

        public VertexInfo(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public int getVertex() {
            return vertex;
        }

        public void setVertex(int vertex) {
            this.vertex = vertex;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
