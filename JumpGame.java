public class JumpGame {

    public static void main(String[] args) {
        int[] nums = {2, 0};
        // System.out.println(canJump(nums));
      //  System.out.println(canJumpDynamic(nums));

        System.out.println(canJumpGreedy(nums));
        ;
    }

    private static boolean canJumpGreedy(int[] nums) {
        int lastIndex = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastIndex) {
                lastIndex = i;
            }
        }

        return lastIndex==0;
    }

    private static boolean canJumpDynamic(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;

        for (int i = nums.length - 2; i >= 0; i--) {
            int farhestPoint = Integer.min(nums.length - 1, i + nums[i]);
            for (int j = i + 1; j <= farhestPoint; j++) {
                if (dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[0];
    }

    private static boolean canJump(int[] nums) {
        boolean[] cache = new boolean[nums.length];
        return canJump(nums, 0, cache);
    }

    private static boolean canJump(int[] nums, int start, boolean[] cache) {
        if (cache[start]) {
            return true;
        }
        if (start == nums.length - 1) {
            return true;
        }
        for (int i = start + 1; i < nums.length && i <= start + nums[start]; i++) {
            if (canJump(nums, i, cache)) {
                cache[start] = true;
                return true;
            }
        }
        return false;
    }
}
