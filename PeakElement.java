public class PeakElement {

    public static void main(String[] args) {

        int[] nums = {2, 1};
        System.out.println(findPeak(nums));
        ;
    }

    private static int findPeak(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int center = left + (right - left) / 2;

            if (nums[center] < nums[center + 1]) {
                left = center + 1;
            } else {
                right = center;
            }
        }

        return left;
    }
}
