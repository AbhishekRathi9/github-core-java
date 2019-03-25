import java.util.Arrays;

public class Surroundedregions {

    public static void main(String[] args) {

        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        solve(board);
    }

    private static void solve(char[][] board) {

        if (board == null || board.length == 0) {
            return;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        System.out.println(Arrays.deepToString(visited));
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                visited[i][j] = true;
                if (board[i][j] == 'O') {
                    solve(board, i, j, visited);
                }
            }
        }
    }

    private static boolean solve(char[][] board, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= board.length - 1 || j < 0 || j >= board[0].length || board[i][j] == 'O') {
            return false;
        }

        boolean top = solve(board, i - 1, j, visited);
        if (!top) {
            return false;
        }
        return false;
    }
}
