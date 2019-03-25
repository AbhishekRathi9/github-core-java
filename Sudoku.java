import java.util.Arrays;

public class Sudoku {

    static int sudokuTable[][] = {
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
    };

    public static void main(String[] args) {

        solveIt(0, 0);
    }

    private static void solveIt(int rowIndex, int columnIndex) {
        if (solutionPossible(rowIndex, columnIndex)) {
            System.out.println(Arrays.deepToString(sudokuTable));
        } else {
            System.out.println("not possible....");
        }
    }

    private static boolean solutionPossible(int rowIndex, int columnIndex) {

        if (rowIndex == sudokuTable.length) {
            rowIndex = 0;
            columnIndex = columnIndex + 1;
            if (columnIndex == sudokuTable.length) {
                return true;
            }
        }

        if (sudokuTable[rowIndex][columnIndex] != 0) {
            return solutionPossible(rowIndex + 1, columnIndex);
        }

        System.out.println(rowIndex);
        for (int number = 1; number < 10; number++) {
            if (ValidNumber(number, rowIndex, columnIndex)) {
                sudokuTable[rowIndex][columnIndex] = number;
                if (solutionPossible(rowIndex + 1, columnIndex)) {
                    return true;
                }
                sudokuTable[rowIndex][columnIndex] = 0;
            }
        }
        return false;
    }

    private static boolean ValidNumber(int number, int rowIndex, int columnIndex) {
        for (int i = 0; i < 9; i++) {
            if (sudokuTable[i][columnIndex] == number) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (sudokuTable[rowIndex][i] == number) {
                return false;
            }
        }

        int rowOffset = rowIndex / 3 * 3;
        int colOffset = columnIndex / 3 * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudokuTable[rowOffset + i][colOffset + j] == number) {
                    return false;
                }
            }
        }

        return true;
    }
}
