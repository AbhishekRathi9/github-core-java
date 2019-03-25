import java.util.Arrays;

public class Maze {

    static int[][] matrix = {
            {1, 0, 0, 0},
            {1, 1, 0, 0},
            {0, 1, 0, 0},
            {0, 1, 1, 1},
    };

    public static void main(String[] args) {
        int[][] solutionMatrix = new int[matrix.length][matrix.length];
        solveIt(solutionMatrix, 0, 0);
    }

    private static void solveIt(int[][] solutionMatrix, int xAxis, int yAxis) {
        if (MazePossible(solutionMatrix, xAxis, yAxis)) {
            System.out.println(Arrays.deepToString(solutionMatrix));
        } else {
            System.out.println("solution not possible");
        }
    }

    private static boolean MazePossible(int[][] solutionMatrix, int xAxis, int yAxis) {
        if (xAxis == solutionMatrix.length - 1 && yAxis == solutionMatrix.length - 1) {
            solutionMatrix[xAxis][yAxis]=1;
            return true;
        }

        if (PossiblePath(xAxis, yAxis)) {
            solutionMatrix[xAxis][yAxis] = 1;
            if (MazePossible(solutionMatrix, xAxis + 1, yAxis)) {
                return true;
            }
            if (MazePossible(solutionMatrix, xAxis, yAxis + 1)) {
                return true;
            }
            solutionMatrix[xAxis][yAxis] = 0;
        }
        return false;
    }

    private static boolean PossiblePath(int xAxis, int yAxis) {
        if (xAxis >= 0 && xAxis < matrix.length && yAxis >= 0 && yAxis < matrix.length && matrix[xAxis][yAxis] == 1) {
            return true;
        }
        return false;
    }
}
