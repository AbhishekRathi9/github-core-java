import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueenProblem2 {

    public static void main(String[] args) {
        int number = 4;

        int[][] matrix = new int[number][number];

        System.out.println(solveNQueens(4));
        ;
    }

    private static List<List<String>> solveNQueens(int n) {
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        dfs(matrix, 0, result);
        return result;
    }

    private static void dfs(char[][] matrix, int column, List<List<String>> result) {
        if (matrix.length == column) {
            result.add(createPath(matrix));
        }

        for (int row = 0; row < matrix.length; row++) {
            if (validPosition(row, column, matrix)) {

                matrix[row][column] = 'Q';
                dfs(matrix, column + 1, result);
                matrix[row][column] = '.';
            }
        }
    }

    private static List<String> createPath(char[][] matrix) {

        List<String> res = new LinkedList<String>();
        for (int i = 0; i < matrix.length; i++) {
            String s = new String(matrix[i]);
            res.add(s);
        }
        return res;
    }

    private static boolean validPosition(int row, int column, char[][] matrix) {
        return isSameRow(row, matrix) && checkLowerDiagonal(row, column, matrix) && checkUpperDiagonal(row, column, matrix);
    }

    private static boolean checkUpperDiagonal(int row, int column, char[][] matrix) {
        while (row != 0 && column != 0) {
            if (matrix[row - 1][column - 1] == 'Q') {
                return false;
            }
            row--;
            column--;
        }

        return true;
    }

    private static boolean checkLowerDiagonal(int row, int column, char[][] matrix) {
        while (row != matrix.length - 1 && column != 0) {
            if (matrix[row + 1][column - 1] == 'Q') {
                return false;
            }
            row++;
            column--;
        }

        return true;
    }

    private static boolean isSameRow(int row, char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[row][i] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
