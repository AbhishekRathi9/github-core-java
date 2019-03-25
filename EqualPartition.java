import java.util.Arrays;

public class EqualPartition {

    public static void main(String[] args) {
        int[] matrix = {2, 5, 11, 5};

        System.out.println(recursionEP(matrix));
    }

    private static boolean recursionEP(int[] matrix) {
        int sum = Arrays.stream(matrix).sum();

        if (sum % 2 != 0) {
            return false;
        } else {
            return solve(matrix, sum / 2, 0, 0, 0);
        }
    }

    private static boolean solve(int[] matrix, int requiredSum, int index, int sum1, int sum2) {


        if (sum1 == requiredSum || sum2 == requiredSum) {
            return true;
        }

        if (index == matrix.length || sum1 > requiredSum || sum2 > requiredSum) {
            return false;
        }
        boolean include = solve(matrix, requiredSum, index + 1, sum1 + matrix[index], sum2);
        boolean exclude = solve(matrix, requiredSum, index + 1, sum1, sum2 + matrix[index]);

        return include || exclude;
    }
}
