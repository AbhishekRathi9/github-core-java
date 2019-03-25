public class MatrixLongestPath {

    public static void main(String[] args) {
//        int matrix[][] = {
//                {1, 2, 9},
//                {3, 5, 8},
//                {4, 6, 7}
//        };

        //[[3,3,14,2,17,12,5]]
        int matrix[][] = {
                {3,3,14,2,17,12,5},

        };
        System.out.println("Length of the longest path is " +
                RecursionLP(matrix));
    }

    private static int RecursionLP(int[][] matrix) {

        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        int max = 0;
        int cache[][] = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Integer.max(max, MLP(matrix, i, j, cache, Integer.MIN_VALUE));
            }
        }
        return max;
    }

    private static int MLP(int[][] matrix, int row, int column, int[][] cache, int previousValue) {

        if (row < 0 || row >= matrix.length || column < 0 || column >= matrix[0].length) {
            return 0;
        }
        if (matrix[row][column] <= previousValue) {
            return 0;
        }

        previousValue = matrix[row][column];

        if (cache[row][column] != 0) {
            return cache[row][column];
        }

        int up = MLP(matrix, row - 1, column, cache, previousValue);
        int down = MLP(matrix, row + 1, column, cache, previousValue);
        int left = MLP(matrix, row, column - 1, cache, previousValue);
        int right = MLP(matrix, row, column + 1, cache, previousValue);

        cache[row][column] = 1 + Integer.max(Integer.max(up, down), Integer.max(left, right));
        return cache[row][column];
    }
}
