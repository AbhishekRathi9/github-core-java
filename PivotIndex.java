public class PivotIndex {

    public static void main(String[] args) {
        int nums[] = {1, 7, 3, 6, 5, 6};

        System.out.println(pivotIndex(nums));

    }

    private static int pivotIndex(int[] nums) {

        if (nums == null) {
            return -1;
        }
        if (nums.length < 3) {
            return -1;
        }

        int totalSum = 0;
        for (int n : nums) {
            totalSum += n;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * leftSum == totalSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}
