import java.util.Arrays;

public class CombinationSum4 {

    private int[] dp;

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        // System.out.println(combinationSum4(nums, 10000));
        int[] cache = new int[1001];
        Arrays.fill(cache, -1);
       // System.out.println(combinationSum4Recursive(nums, 999, cache));
        combinationSum4BottomUp(nums, 4);
    }

    private static int combinationSum4BottomUp(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i < target + 1; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        System.out.println(dp[target]);
        return dp[target];
    }

    private static int combinationSum4Recursive(int[] nums, int target, int[] cache) {

        if (cache[target] != -1) {
            return cache[target];
        }
        if (target == 0) {
            return 1;
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                res = res + combinationSum4Recursive(nums, target - nums[i], cache);
            }
        }
        cache[target] = res;
        return res;
    }

    private static int combinationSum4(int[] nums, int target) {

        if (nums.length == 0) {
            return 1;
        }
        Arrays.sort(nums);
        int count = 0;
        return combinationSumHelper(nums, target, count);
    }

    private static int combinationSumHelper(int[] candidates, int target, int count) {
        if (target == 0) {
            count++;
            return count;
        }
        if (target < 0) {
            return 0;
        }
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }

            count = combinationSumHelper(candidates, target - candidates[i], count);
        }
        return count;
    }
}
