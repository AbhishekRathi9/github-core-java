public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        missingNumber(nums);
    }

    private static int missingNumber(int[] nums) {
        int result = nums.length;

        for ( int i = 0; i < nums.length; i++) {
            result = result ^ i ^ nums[i];
        }
        System.out.println(result);

        return result;
    }
}
