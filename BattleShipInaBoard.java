public class BattleShipInaBoard {

    public static void main(String[] args) {

        char[][] board = {
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'}
        };

        // countBattleships(board);
        countBattleshipsii(board);
    }

    private static int countBattleshipsii(char[][] board) {
        int result = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.')) {
                    result++;
                }
            }
        }
        System.out.println(result);
        return result;
    }

    private static int countBattleships(char[][] board) {
        int result = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    result++;
                    sink(board, i, j);
                }
            }
        }
        System.out.println(result);
        return result;
    }

    private static void sink(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col >= board[0].length || col < 0 || board[row][col] == '.') {
            return;
        }
        board[row][col] = '.';
        sink(board, row - 1, col);
        sink(board, row + 1, col);
        sink(board, row, col - 1);
        sink(board, row, col + 1);
    }
}
