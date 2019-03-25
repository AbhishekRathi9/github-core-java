package graph;

import graph.AdjacentMatrixGraph;
import graph.Graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Stack;

public class Dijkstra {

    public static void main(String[] args) {
        Graph graph1 = new AdjacentMatrixGraph(8, Graph.GRAPH_TYPE.DIRECTED);
        graph1.addWeightedEdge(2, 7, 4);
        graph1.addWeightedEdge(0, 3, 2);
        graph1.addWeightedEdge(0, 4, 2);
        graph1.addWeightedEdge(0, 1, 1);
        graph1.addWeightedEdge(2, 1, 3);
        graph1.addWeightedEdge(1, 3, 2);
        graph1.addWeightedEdge(3, 5, 1);
        graph1.addWeightedEdge(3, 6, 3);
        graph1.addWeightedEdge(4, 7, 2);
        graph1.addWeightedEdge(7, 5, 4);

        //        graph1.addWeightedEdge(0, 1, 50);
        //        graph1.addWeightedEdge(0, 2, 40);
        //        graph1.addWeightedEdge(1, 2, -30);

        shortestPath(graph1, 0, 5);
    }

    private static void shortestPath(Graph graph1, int start, int end) {

        Map<Integer, DistanceInfo> distanceInfoMap = new HashMap<>();
        for (int i = 0; i < graph1.getNumVertices(); i++) {
            distanceInfoMap.put(i, new DistanceInfo(Integer.MAX_VALUE, -1));
        }

        //        Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();
        //        for (int i = 0; i < graph1.getNumVertices(); i++) {
        //            vertexInfoMap.put(i, new VertexInfo(i, -1));
        //        }

        PriorityQueue<VertexInfo> queue = new PriorityQueue<>(new Comparator<VertexInfo>() {
            @Override
            public int compare(VertexInfo o1, VertexInfo o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        });

        distanceInfoMap.get(start).setDistance(0);
        distanceInfoMap.get(start).setLastVertex(start);
        queue.add(new VertexInfo(start, 0));
        int[] visited = new int[graph1.getNumVertices()];
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll().getVertex();
            visited[currentVertex] = 1;
            List<Integer> adjacentVertices = graph1.getAdjacentVertices(currentVertex);
            for (int neighbour : adjacentVertices) {
                if (visited[neighbour] == 1) {
                    continue;
                }
                int newDistance = distanceInfoMap.get(currentVertex).getDistance() + graph1.getWeightedEdge(currentVertex, neighbour);
                int existingDistance = distanceInfoMap.get(neighbour).getDistance();
                // queue.add(new VertexInfo(neighbour, existingDistance));
                if (newDistance < existingDistance) {
                    distanceInfoMap.get(neighbour).setLastVertex(currentVertex);
                    distanceInfoMap.get(neighbour).setDistance(newDistance);
                    if (queue.contains(new VertexInfo(neighbour))) {
                        queue.remove(new VertexInfo(neighbour));
                    }
                    queue.add(new VertexInfo(neighbour, newDistance));
                }
            }
        }
        Stack<Integer> stack = new Stack<>();
        stack.add(end);
        int lastVertex = distanceInfoMap.get(end).getLastVertex();
        while (lastVertex != -1 && lastVertex != start) {
            stack.add(lastVertex);
            lastVertex = distanceInfoMap.get(lastVertex).getLastVertex();
        }
        if (lastVertex == -1) {
            System.out.println("no path exists");
        } else {
            System.out.print("Smallest Path is " + start);
            while (!stack.isEmpty()) {
                System.out.println("-->" + stack.pop());
            }
        }
    }

    static class VertexInfo {

        private int vertex;
        private int weight;

        public VertexInfo(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public VertexInfo(int neighbour) {}

        public int getVertex() {
            return vertex;
        }

        public void setVertex(int vertex) {
            this.vertex = vertex;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            VertexInfo that = (VertexInfo) o;
            return vertex == that.vertex;
        }

        @Override
        public int hashCode() {
            return Objects.hash(vertex);
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
