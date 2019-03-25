import java.util.Arrays;

public class Houserobber {

    public static void main(String[] args) {

        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));

        System.out.println(robDynamic(nums));

        robLessSpaceComplexity(nums);
        ;
    }

    private static int robLessSpaceComplexity(int[] nums) {

        int prev1 = 0;
        int prev2 = 0;

        for (int n : nums) {
            int temp = prev1;
            prev1 = Integer.max(prev1, prev2 + n);
            prev2 = temp;
        }
        return Integer.max(prev1, prev2);
    }

    private static int robDynamic(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Integer.max(dp[i], dp[i - 1] + nums[i]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[nums.length];
    }

    private static int rob(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return robRecursion(nums, 0, cache);
    }

    private static int robRecursion(int[] nums, int index, int[] cache) {
        if (index >= nums.length) {
            return 0;
        }
        if (cache[index] != -1) {
            return cache[index];
        }
        int include = nums[index] + robRecursion(nums, index + 2, cache);
        int exclude = robRecursion(nums, index + 1, cache);
        cache[index] = Integer.max(include, exclude);
        return cache[index];
    }
}
