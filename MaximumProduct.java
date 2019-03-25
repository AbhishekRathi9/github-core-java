import java.util.Arrays;

public class MaximumProduct {

    public static void main(String[] args) {
        int[] nums = {-1,-2,3,5};
        System.out.println( maximumProduct(nums));;
    }

    private static int maximumProduct(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);

        return Integer.max(nums[length-1]*nums[length-2]*nums[length-3],nums[length-1]*nums[0]*nums[1]);
    }
}
