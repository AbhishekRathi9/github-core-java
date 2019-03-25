import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 9};
        // int[] nums = {0, 0, 1};
        // moveZeroes(nums);
        moveZeroes2(nums);

        System.out.println(Arrays.toString(nums));
    }

    private static void moveZeroes2(int[] nums) {

        int inserPos = 0;

        for (int n : nums) {
            if (n != 0) {
                nums[inserPos] = n;
                inserPos++;
            }
        }

        while (inserPos < nums.length) {
            nums[inserPos] = 0;
            inserPos++;
        }
    }

    private static void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;

        while (j < nums.length) {

            if (nums[j] == 0) {
                j++;
            } else {
                swap(nums, i, j);
                i++;
                j++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
