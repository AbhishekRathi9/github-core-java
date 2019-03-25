public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1, 5};
        int target = 7;

        for (int i = 0; i < 10; i++) {
            System.out.println(searchInsert(nums, i));
            System.out.println( searchInsertii(nums, i));
        }

       // searchInsertii(nums, 7);
        ;
    }

    private static int searchInsertii(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int center = start + (end - start) / 2;

            if (nums[center] == target) {
                return center;
            }
            if (target > nums[center]) {
                start = center;
            } else {
                end = center;
            }
        }

        if (target > nums[end]) {
            return end + 1;
        } else if (target <= nums[start]) {
            return start;
        } else {
            return start + 1;
        }
    }

    private static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        if (nums.length == 1) {
            if (target <= nums[0]) {
                return 0;
            }
            return 1;
        }

        while (low < high) {
            int center = low + (high - low) / 2;
            if (target > nums[center]) {
                if (target > nums[high]) {
                    return high + 1;
                }
                low = center + 1;
            } else {
                high = center;
            }
        }
        return low;
    }
}
