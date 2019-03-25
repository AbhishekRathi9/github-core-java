import java.util.Arrays;

public class KnightsTour {

    public static void main(String[] args) {

        int[][] matrix = new int[5][5];
        int[] xAxis ={2, 1, -1, -2, -2, -1, 1, 2};
        int[] yAxis =  {1, 2, 2, 1, -1, -2, -2, -1};

//        for (int[] row : matrix) {
//            Arrays.fill(row, -1);
//        }

        matrix[0][0] = 1;
        solveIt(matrix, xAxis, yAxis, 0, 0, 2);
    }

    private static void solveIt(int[][] matrix, int[] xAxis, int[] yAxis, int currentXPosition, int currentYPosition, int stepNumber) {
        if (solutionPossible(matrix, xAxis, yAxis, currentXPosition, currentYPosition, stepNumber)) {
            System.out.println(Arrays.deepToString(matrix));
        } else {
            System.out.println(Arrays.deepToString(matrix));
            System.out.println("not possible");
        }
    }

    private static boolean solutionPossible(int[][] matrix, int[] xAxis, int[] yAxis, int currentXPosition, int currentYPosition,
            int stepNumber) {
        if (stepNumber > matrix.length * matrix.length) {
            return true;
        }
        for (int i = 0; i < xAxis.length; i++) {
            int nextXStep = currentXPosition + xAxis[i];
            int nextYStep = currentYPosition + yAxis[i];
            if (isValidStep(nextXStep, nextYStep, matrix)) {
                matrix[nextXStep][nextYStep] = stepNumber;
                if (solutionPossible(matrix, xAxis, yAxis, nextXStep, nextYStep, stepNumber + 1)) {
                    return true;
                }
                matrix[nextXStep][nextYStep] = 0;
            }
        }
        return false;
    }

    private static boolean isValidStep(int xPosition, int yPosition, int[][] matrix) {
        if (xPosition >= 0 && xPosition < matrix.length && yPosition >= 0 && yPosition < matrix.length
                && matrix[xPosition][yPosition] == 0) {
            return true;
        }
        return false;
    }
}
