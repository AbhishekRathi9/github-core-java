import java.util.Arrays;

public class NQueenProblem {

    public static void main(String[] args) {
        int number = 4;

        int[][] matrix = new int[number][number];

        if (applyLogic(0, matrix)) {
        } else {
            System.out.println("solution aint possible");
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    private static boolean applyLogic(int column, int[][] matrix) {
        if (column == matrix.length) {
            return true;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (isValidPlace(i, column, matrix)) {
                matrix[i][column] = 1;
                if (applyLogic(column + 1, matrix)) {
                    return true;
                }
                //backtracking
                matrix[i][column] = 0;
            }
        }
        return false;
    }

    private static boolean isValidPlace(int row, int column, int[][] matrix) {
        System.out.println("checking validation for row-->" + row + " and column-->" + column);
        return isSameRow(matrix, column, row) && notAcross(row, column, matrix);
    }

    private static boolean notAcross(int row, int column, int[][] matrix) {
        return notAccrossUpwards(row, column, matrix) && notAccrossDownwards(row, column, matrix);
    }

    private static boolean notAccrossDownwards(int row, int column, int[][] matrix) {
        while (row <= 3 && column >= 0) {
            if (matrix[row][column] == 1) {
                return false;
            }
            row++;
            column--;
        }
        return true;
    }

    private static boolean notAccrossUpwards(int row, int column, int[][] matrix) {
        while (row >= 0 && column >= 0) {
            if (matrix[row][column] == 1) {
                return false;
            }
            row--;
            column--;
        }
        return true;
    }

    private static boolean isSameRow(int[][] matrix, int column, int row) {
        while (column >= 0) {
            if (matrix[row][column] == 1) {
                return false;
            }
            column--;
        }
        return true;
    }
}
