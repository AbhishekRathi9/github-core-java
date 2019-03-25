public class MaximumSubArray {

    public static void main(String[] args) {

        int[] numbers = {1, -3, 2, 1, -1};
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum = 0;
            for (int j = i; j < numbers.length; j++) {
                sum = sum + numbers[j];
                result = Integer.max(sum, result);
            }
        }

        System.out.println(result);

        kadanes(numbers);
        divideAndConquer(numbers);
    }

    private static int divideAndConquer(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return divideAndConquer(nums, 0, nums.length - 1);
    }

    private static int divideAndConquer(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int center = (end + start) / 2;
        int left = divideAndConquer(nums, start, center);
        int right = divideAndConquer(nums, center + 1, end);
        int middle = recurse(nums, start, end, center);

        return Integer.max(Integer.max(left, right), middle);
    }

    private static int recurse(int[] nums, int start, int end, int center) {

        int leftSum = 0;
        int maxLeft = Integer.MIN_VALUE;
        for (int i = center; i >= start; i--) {
            leftSum = leftSum + nums[i];
            maxLeft = Integer.max(maxLeft, leftSum);
        }

        int rightSum = 0;
        int maxRight = Integer.MIN_VALUE;
        for (int i = center + 1; i <= end; i++) {
            rightSum = rightSum + nums[i];
            maxRight = Integer.max(maxRight, rightSum);
        }

        return maxLeft + maxRight;
    }

    private static int kadanes(int[] numbers) {

        int maxSum = numbers[0];
        int GlobalMaxSum = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            maxSum = Integer.max(numbers[i], maxSum + numbers[i]);
            GlobalMaxSum = Integer.max(GlobalMaxSum, maxSum);
        }
        System.out.println(GlobalMaxSum);
        return GlobalMaxSum;
    }
}
