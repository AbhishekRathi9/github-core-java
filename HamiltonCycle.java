import java.util.Arrays;

public class HamiltonCycle {

    public static void main(String[] args) {

        int[][] matrix = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0}
        };

        int[] array = new int[matrix.length];
        Arrays.fill(array, -1);
        array[0] = 0;
        solve(matrix, array, 1);
    }

    private static void solve(int[][] matrix, int[] array, int source) {
        if (solutionPossible(matrix, array, source)) {
            System.out.println(Arrays.toString(array));
        } else {
            System.out.println("solution aint possible");
        }
    }

    private static boolean solutionPossible(int[][] matrix, int[] array, int arrayIndex) {
        if (arrayIndex == matrix.length && matrix[array[arrayIndex-1]][array[0]]==1) {
            return true;
        }
        for (int vertex = 0; vertex < matrix.length; vertex++) {
            if (isValidPath( array, arrayIndex, vertex)) {
                array[arrayIndex] = vertex;
                if (solutionPossible(matrix, array, arrayIndex + 1)) {
                    return true;
                }
                array[arrayIndex] = -1;
            }
        }
        return false;
    }

    private static boolean isValidPath(int[] array, int arrayIndex, int vertex) {
        for (int index = 0; index < arrayIndex; index++) {
            if (array[index] == vertex) {
                return false;
            }
        }
        return true;
    }
}
