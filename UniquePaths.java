import java.util.Arrays;

public class UniquePaths {

    private static int path;

    public static void main(String[] args) {

        uniquePathsDynamic(7, 3);
        uniquePathsDynamicLessSpace(7, 3);
        System.out.println(uniquePathsRecursion(7, 3));
        uniquePathsBackTracking(7, 3);
        ;
    }

    private static void uniquePathsBackTracking(int row, int columns) {

        backtrack(row, columns, 0, 0);
        System.out.println(path);
    }

    private static void backtrack(int row, int columns, int i, int j) {
        if (i >= row) {
            return;
        }
        if (j >= columns) {
            return;
        }
        if (i == row - 1 && j == columns - 1) {
            path++;
            return;
        }
        backtrack(row, columns, i + 1, j);
        backtrack(row, columns, i, j + 1);
    }

    private static int uniquePathsRecursion(int m, int n) {
        int cache[][] = new int[m][n];
        return uniquePathsHelper(m - 1, n - 1, cache);
    }

    private static int uniquePathsHelper(int m, int n, int[][] cache) {

        if (m < 0 || n < 0) {
            return 0;
        }
        if (m == 0 && n == 0) {
            cache[m][n] = 1;
            return cache[m][n];
        }
        if (cache[m][n] > 0) {
            return cache[m][n];
        } else {
            cache[m][n] = uniquePathsHelper(m - 1, n, cache) + uniquePathsHelper(m, n - 1, cache);
            return cache[m][n];
        }
    }

    private static int uniquePathsDynamicLessSpace(int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        }

        int[] row = new int[m];
        Arrays.fill(row, 1);

        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                row[i] = row[i] + row[i - 1];
            }
        }

        System.out.println(row[m - 1]);
        return row[m - 1];
    }

    private static int uniquePathsDynamic(int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        }
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        System.out.println(dp[m - 1][n - 1]);
        return dp[m - 1][n - 1];
    }
}
