import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayTwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(findTwoSumIndex(nums, target)));
        System.out.println(Arrays.toString(findTwoSumIndexUsingHashMap(nums, target)));
    }

    private static int[] findTwoSumIndexUsingHashMap(int[] nums, int target) {
        Map<Integer, Integer> numberIndexmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numberIndexmap.containsKey(target - nums[i])) {
                return new int[]{i, target - nums[i]};
            } else {
                numberIndexmap.put(nums[i], i);
            }
        }
        return new int[]{0, 0};
    }

    private static int[] findTwoSumIndex(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] + nums[end] > target) {
                end--;
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                return new int[]{start, end};
            }
        }
        return new int[]{0, 0};
    }
}
