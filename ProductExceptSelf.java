import java.util.Arrays;

public class ProductExceptSelf {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        productExceptSelf(nums);
    }

    private static int[] productExceptSelf(int[] nums) {

        int[] left = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            left[i] = left[i] * right;
            right = right * nums[i];
        }

        //        int[] product = new int[nums.length];
        //        for (int i = 0; i < nums.length; i++) {
        //            product[i] = left[i] * right[i];
        //        }
        System.out.println(Arrays.toString(left));
        return null;
    }
}
