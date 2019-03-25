import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {

        int[] nums = {-1, 2, 1, -4};
        threeSumClosest(nums, 1);
    }

    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int low = i+1;
            int high = nums.length - 1;
            int currentsum = 0;
            while (low < high) {
                currentsum = nums[i] + nums[low] + nums[high];
                if (Math.abs(currentsum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentsum;
                }
                if (currentsum > target) {
                    high--;
                }
                if (currentsum < target) {
                    low++;
                }
                if (closestSum == target) {
                    return closestSum;
                }
            }
        }
        System.out.println(closestSum);
        return closestSum;
    }
}

//
//   Arrays.sort(nums);
//           int result = nums[0] + nums[1] + nums[2];
//
//           for (int i = 0; i < nums.length - 2; i++) {
//        if (i != 0 && nums[i - 1] == nums[i]) {
//        continue;
//        }
//        int low = i + 1;
//        int high = nums.length - 1;
//        int currentSum = 0;
//        while (low < high) {
//        currentSum = nums[i] + nums[low] + nums[high];
//        if (Math.abs(currentSum - target) < Math.abs(result - target)) {
//        result = currentSum;
//        }
//        if (currentSum > target) {
//        high--;
//        }
//        if (currentSum < target) {
//        low++;
//        }
//        if(currentSum == target){
//        return result;
//        }
//        }
//        }
//        System.out.println(result);
//        return result;