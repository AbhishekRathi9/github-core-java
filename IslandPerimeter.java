public class IslandPerimeter {

    public static void main(String[] args) {

        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        islandPerimeter(grid);
    }

    private static int islandPerimeter(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter = findPerimeter(grid, i, j);
                }
            }
        }
        System.out.println(perimeter);
        return perimeter;
    }

    private static int findPerimeter(int[][] grid, int i, int j) {
        if (i >= grid.length || i < 0 || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == -1) {
            return 0;
        }
        grid[i][j] = -1;
        int left = 0;
        int right = 0;
        int top = 0;
        int down = 0;
        top = findPerimeter(grid, i - 1, j);
        down = findPerimeter(grid, i + 1, j);
        left = findPerimeter(grid, i, j - 1);
        right = findPerimeter(grid, i, j + 1);

        return top + down + left + right;
    }
}
