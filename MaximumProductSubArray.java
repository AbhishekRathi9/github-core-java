public class MaximumProductSubArray {

    public static void main(String[] args) {
        int[] nums = {-1,9,20,0,-9,-5};

        maxProduct(nums);

        maxProduct2(nums);
    }

    private static int maxProduct2(int[] nums) {

        int currentMax = nums[0];
        int currentMin = nums[0];
        int previousMax = nums[0];
        int previousMin = nums[0];

        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Integer.max(Integer.max(previousMax * nums[i], previousMin * nums[i]), nums[i]);
            currentMin = Integer.min(Integer.min(previousMax * nums[i], previousMin * nums[i]), nums[i]);
            previousMax = currentMax;
            previousMin = currentMin;

            result = Integer.max(result, currentMax);
        }
        System.out.println(result);
        return result;
    }

    private static int maxProduct(int[] nums) {

        int max = nums[0];
        int min = nums[0];

        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Integer.max(max * nums[i], nums[i]);
            min = Integer.min(min * nums[i], nums[i]);

            result = Integer.max(result, max);
        }
        System.out.println(result);
        return result;
    }
}
