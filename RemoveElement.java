public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;

        remove(nums, val);
    }

    private static int remove(int[] nums, int val) {

        int indexPos = 0;

        for (int n : nums) {
            if (n != val) {
                nums[indexPos] = n;
                indexPos++;
            }
        }
        return indexPos;
    }
}
