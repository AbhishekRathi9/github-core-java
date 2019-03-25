import java.util.Arrays;

public class PartitionSum {

    public static void main(String[] args) {

        int nums[] = {4, 3, 4, 3};
        System.out.println(canPartition(nums));
    }

    private static boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        return subSetdynamic(nums, sum / 2);
    }

    private static boolean subSetdynamic(int[] set, int sum) {
        boolean[][] matrix = new boolean[set.length + 1][sum + 1];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = true;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (set[i - 1] > j) {
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    matrix[i][j] = matrix[i - 1][j] || matrix[i - 1][j - set[i - 1]];
                }
            }
            if (matrix[i][sum]) {
                return true;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        return matrix[set.length][sum];
    }
}
