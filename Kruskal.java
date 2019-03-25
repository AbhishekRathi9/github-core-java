package graph;

import graph.AdjacentMatrixGraph;
import graph.Graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Kruskal {

    public static void main(String[] args) {

        Graph graph1 = new AdjacentMatrixGraph(8, Graph.GRAPH_TYPE.DIRECTED);

        graph1.addWeightedEdge(0, 1, 1);
        graph1.addWeightedEdge(0, 2, 2);
        graph1.addWeightedEdge(2, 3, 3);
        graph1.addWeightedEdge(3, 1, 2);
        graph1.addWeightedEdge(3, 4, 7);
        graph1.addWeightedEdge(1, 4, 8);

        mst(graph1);
    }

    private static void mst(Graph graph1) {

        PriorityQueue<EdgeInfo> queue = new PriorityQueue<>(new Comparator<EdgeInfo>() {
            @Override
            public int compare(EdgeInfo o1, EdgeInfo o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        });

        for (int i = 0; i < graph1.getNumVertices(); i++) {
            for (int neighbour : graph1.getAdjacentVertices(i)) {
                queue.add(new EdgeInfo(i, neighbour, graph1.getWeightedEdge(i, neighbour)));
            }
        }

        Map<Integer, Set> edgeInfoMap = new HashMap<>();
        for (int i = 0; i < graph1.getNumVertices(); i++) {
            edgeInfoMap.put(i, new HashSet<Integer>());
        }

        Set<EdgeInfo> spanningTree = new HashSet<>();

        while (!queue.isEmpty() && spanningTree.size() != graph1.getNumVertices() - 1) {
            EdgeInfo edgeInfo = queue.poll();

            edgeInfoMap.get(edgeInfo.getVertex1()).add(edgeInfo.getVertex2());
            //System.out.println(hasCycle(edgeInfoMap));
            if (hasCycle(edgeInfoMap)) {
                edgeInfoMap.get(edgeInfo.getVertex1()).remove(edgeInfo.getVertex2());
                continue;
            }
            spanningTree.add(edgeInfo);
        }

        System.out.println(spanningTree);
    }

    private static boolean hasCycle(Map<Integer, Set> edgeInfoMap) {
        Set<Integer> vertices = edgeInfoMap.keySet();
        Queue<Integer> queue = new LinkedList<>();

        for (int vertex : vertices) {
            Set<Integer> visited = new HashSet<>();
            Set edges = edgeInfoMap.get(vertex);
            queue.addAll(edges);
            while (!queue.isEmpty()) {

                Integer edge = queue.poll();
                if (visited.contains(edge)) {
                    return true;
                }
                visited.add(edge);
                queue.addAll(edgeInfoMap.get(edge));
            }
        }
        return false;
    }

    static class EdgeInfo {

        private int vertex1;
        private int vertex2;
        private int weight;

        public EdgeInfo(int vertex1, int vertex2, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }

        public int getVertex1() {
            return vertex1;
        }

        public void setVertex1(int vertex1) {
            this.vertex1 = vertex1;
        }

        public int getVertex2() {
            return vertex2;
        }

        public void setVertex2(int vertex2) {
            this.vertex2 = vertex2;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return String.valueOf(vertex1) + String.valueOf(vertex2);
        }
    }
}
