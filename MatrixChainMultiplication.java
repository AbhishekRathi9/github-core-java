import java.util.Arrays;

public class MatrixChainMultiplication {

    public static void main(String[] args) {
        int[] dimensions = {5, 4, 6, 2, 3};
        int[][] cache = new int[dimensions.length][dimensions.length];
        int count = recursionLogic(dimensions, 1, dimensions.length - 1, cache);
        System.out.println(count);
        dynamicprogramingLogic(dimensions);
    }

    private static void dynamicprogramingLogic(int[] dimensions) {
        int[][] matrix = new int[dimensions.length][dimensions.length];
        int[][] tracingMatrix = new int[dimensions.length][dimensions.length];
        int size = matrix.length;

        for (int d = 1; d < size - 1; d++) {
            for (int i = 1; i < size - d; i++) {
                int j = i + d;
                int tem = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int result = matrix[i][k] + matrix[k + 1][j] + dimensions[i - 1] * dimensions[k] * dimensions[j];
                    if (result < tem) {
                        tem = result;
                        tracingMatrix[i][j] = k;
                    }
                }
                matrix[i][j] = tem;
            }
        }


        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.deepToString(tracingMatrix));
    }

    private static int recursionLogic(int[] dimensions, int start, int end, int[][] cache) {
        if (start == end) {
            return 0;
        }
        int q = Integer.MAX_VALUE;

        if (cache[start][end] == 0) {
            for (int k = start; k < end; k++) {
                q = Integer.min(q, recursionLogic(dimensions, start, k, cache) + recursionLogic(dimensions, k + 1, end, cache)
                        + dimensions[start - 1] * dimensions[k] * dimensions[end]);
                cache[start][end] = q;
            }
        }

        return cache[start][end];
    }
    //        if (i == j) {
    //            return 0;
    //        }
    //        int minCalculation = 32767;
    //
    //        for (int k = i; k < j; k++) {
    //            int count = recursionLogic(dimensions, i, k) + recursionLogic(dimensions, k + 1, j) + dimensions[i - 1] * dimensions[k]
    //                    * dimensions[j];
    //            if (minCalculation > count) {
    //                minCalculation = count;
    //            }
    //        }
    //
    //        return minCalculation;
    //    }
}
