public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        // removeDuplicates(nums);
        removeDuplicatesii(nums);
    }

    private static int removeDuplicatesii(int[] nums) {
        int index = 1;
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                count = 0;
                nums[index++] = nums[i];
            } else {
                count++;
                if (count < 2) {
                    nums[index++] = nums[i];
                }
            }
        }

        return index;
    }

    private static int removeDuplicates(int[] nums) {
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
