import org.omg.CORBA.INTERNAL;

import java.util.Arrays;

public class FloydWarshall {

    public static void main(String[] args) {
        int[][] graph = {
                {0, 5, 99999, 10},
                {99999, 0, 3, 99999},
                {99999, 99999, 0, 1},
                {99999, 99999, 99999, 0}
        };

        applyLogic(graph);
        System.out.println(Arrays.deepToString(graph).replaceAll("99999","INF"));
    }

    private static void applyLogic(int[][] graph) {
        for (int k = 0; k < graph.length; k++) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }
}
