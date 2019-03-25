public class Searchrange {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 1;

        System.out.println(searchRange(nums, target));
        ;
    }

    private static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = search(nums, target, true);
        result[1] = search(nums, target, false);
        return result;
    }

    private static int search(int[] nums, int target, boolean findFirstOccurence) {
        int low = 0;
        int high = nums.length - 1;
        int result = -1;
        while (low <= high) {
            int center = low + (high - low) / 2;
            if (target == nums[center]) {
                result = center;
                if (findFirstOccurence) {
                    high = center - 1;
                } else {
                    low = center + 1;
                }
            } else if (target > nums[center]) {
                low = center + 1;
            } else {
                high = center - 1;
            }
        }
        return result;
    }
}
