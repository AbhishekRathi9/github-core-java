public class UniquePathsWithObstacles {

    public static void main(String[] args) {

        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int rows = obstacleGrid.length - 1;
        int columns = obstacleGrid[0].length - 1;
        // System.out.println(uniquePathsWithObstacles(obstacleGrid, rows, columns, new int[rows + 1][columns + 1]));
        uniquePathsWithObstaclesDynamic(obstacleGrid, obstacleGrid.length, obstacleGrid[0].length - 1);
    }

    private static int uniquePathsWithObstaclesDynamic(int[][] obstacleGrid, int m, int n) {

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                return 0;
            }
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                return 0;
            }
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        System.out.println(dp[m - 1][n - 1]);
        return dp[m - 1][n - 1];
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid, int row, int column, int[][] cache) {
        if (row < 0 || column < 0 || obstacleGrid[row][column] == 1) {
            return 0;
        }

        if (cache[row][column] > 0) {
            return cache[row][column];
        }
        if (row == 0 && column == 0) {
            cache[row][column] = 1;
            return cache[row][column];
        }
        cache[row][column] =
                uniquePathsWithObstacles(obstacleGrid, row - 1, column, cache) + uniquePathsWithObstacles(obstacleGrid, row, column - 1,
                        cache);
        return cache[row][column];
    }
}
