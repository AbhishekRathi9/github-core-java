import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinPathSum {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        //  System.out.println(minPathSumDynamic(grid));

        List<Integer> sums = new ArrayList<>();

        System.out.println(minPathSumRecursive(grid, 0, 0));
        ;
    }

    private static int minPathSumRecursive(int[][] grid, int row, int column) {
        if (row >= grid.length || column >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (row == grid.length - 1 && column == grid[0].length - 1) {
            return grid[row][column];
        }

        int down = minPathSumRecursive(grid, row, column + 1);
        int right = minPathSumRecursive(grid, row + 1, column);

        return grid[row][column] + Integer.min(down, right);
    }

    private static int minPathSumDynamic(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] dp = new int[rows][columns];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < columns; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int row = 1; row < rows; row++) {
            for (int column = 1; column < columns; column++) {
                dp[row][column] = Integer.min(dp[row - 1][column], dp[row][column - 1]) + grid[row][column];
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[rows - 1][columns - 1];
    }
}
