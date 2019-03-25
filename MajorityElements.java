import java.util.Arrays;

public class MajorityElements {

    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        majorityElement(nums);
    }

    private static int majorityElement(int[] nums) {

        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
