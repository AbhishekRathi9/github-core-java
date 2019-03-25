import java.util.Arrays;

public class GraphColorProblem {

    public static void main(String[] args) {
         /* Create following graph and test whether it is
           3 colorable
          (3)---(2)
           |   / |
           |  /  |
           | /   |
          (0)---(1)
        */
        int graph[][] = {
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0},
        };
        int numColor = 3; // Number of colors

        int[] colorArray = new int[graph.length];
        Arrays.fill(colorArray,-1);

        solveIt(graph, numColor, colorArray);
    }

    private static void solveIt(int[][] graph, int numColor, int[] colorArray) {
        if (solutionPossible(graph, numColor, colorArray, 0)) {
            System.out.println("solution possible");
            System.out.println(Arrays.toString(colorArray));
        } else {
            System.out.println("solution aint possible");
        }
    }

    private static boolean solutionPossible(int[][] graph, int numColor, int[] colorArray, int vertexNumber) {
        if (graph.length == vertexNumber) {
            return true;
        }

        for (int colorIndex = 0; colorIndex < numColor; colorIndex++) {
            if (IsValidColorPosition(graph, colorIndex, vertexNumber, colorArray)) {
                colorArray[vertexNumber] = colorIndex;
                if (solutionPossible(graph, numColor, colorArray, vertexNumber + 1)) {
                    return true;
                }
                colorArray[vertexNumber] = 0; //backtracking
            }
        }
        return false;
    }

    private static boolean IsValidColorPosition(int[][] graph, int colorIndex, int currentVertex, int[] colorArray) {
        for (int vertice = 0; vertice < graph.length; vertice++) {
            if (graph[vertice][currentVertex] == 1 && colorArray[vertice] == colorIndex) {
                return false;
            }
        }
        return true;
    }
}
