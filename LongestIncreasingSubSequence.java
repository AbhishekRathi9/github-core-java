import java.util.Arrays;

public class LongestIncreasingSubSequence {

    public static void main(String[] args) {

        int[] numbers = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        //int[] numbers = {3, 2, 6, 4, 1, 5};

        System.out.println(LISRecursion(numbers));
        System.out.println(Lisdynamic(numbers));
        ;
        ;
    }

    private static int Lisdynamic(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && 1 + result[j] > result[i]) {

                    result[i] = result[j] + 1;
                    max = Integer.max(max, result[i]);
                }
            }
        }
        System.out.println(Arrays.toString(result));
        return max;
    }

    private static int LISRecursion(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        int[][] cache = new int[numbers.length + 1][numbers.length + 1];
        return helper(numbers, -1, 0, cache);
    }

    private static int helper(int[] numbers, int previousIndex, int currentPosition, int[][] cache) {
        if (cache[currentPosition][previousIndex + 1] != 0) {
            return cache[currentPosition][previousIndex + 1];
        }

        if (currentPosition == numbers.length) {
            return 0;
        }

        int exclude = helper(numbers, previousIndex, currentPosition + 1, cache);

        int include = 0;
        if (previousIndex < 0 || numbers[currentPosition] > numbers[previousIndex]) {
            include = 1 + helper(numbers, currentPosition, currentPosition + 1, cache);
        }

        cache[currentPosition][previousIndex + 1] = Integer.max(include, exclude);
        return cache[currentPosition][previousIndex + 1];
    }
}
