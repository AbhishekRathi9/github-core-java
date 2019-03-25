public class MaxAreaIsland {

    public static void main(String[] args) {

        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        //        int[][] grid = {
        //                {1,1},
        //                {0,1},
        //                {0,0},
        //        };

        maxAreaOfIsland(grid);
    }

    private static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea,  findMaxArea(grid, i, j));
                }
            }
        }
        System.out.println(maxArea);
        return maxArea;
    }

    private static int findMaxArea(int[][] grid, int i, int j) {
        if (i >= grid.length || i < 0 || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;
        int left = 0;
        int right = 0;
        int top = 0;
        int down = 0;
        top =  findMaxArea(grid, i - 1, j);
        down = findMaxArea(grid, i + 1, j);
        left = findMaxArea(grid, i, j - 1);
        right = findMaxArea(grid, i, j + 1);

        return 1 +top + down + left + right;
    }
}
