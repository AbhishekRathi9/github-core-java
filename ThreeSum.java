import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }

    private static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int low = i + 1;
            int high = nums.length - 1;
            int sum = 0;
            while (low < high) {
                sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[low]);
                    triplet.add(nums[high]);
                    result.add(triplet);

                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }
                }
                if (sum > 0) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        System.out.println(result);
        return result;
        //        List<List<Integer>> result = new ArrayList<>();
        //        Arrays.sort(nums);
        //
        //        for (int i = 0; i < nums.length - 2; i++) {
        //            if (i > 0 && nums[i] == nums[i - 1]) {
        //                continue;
        //            }
        //            int low = i + 1;
        //            int high = nums.length - 1;
        //            int sum = 0;
        //            while (low < high) {
        //                sum = nums[i] + nums[low] + nums[high];
        //                if (sum == 0) {
        //                    List<Integer> triplet = new ArrayList<>();
        //                    triplet.add(nums[high]);
        //                    triplet.add(nums[i]);
        //                    triplet.add(nums[low]);
        //                    result.add(triplet);
        //                    while (low < high && nums[low] == nums[low+1]) {
        //                        low++;
        //                    }
        //                    while (low < high && nums[high] == nums[high-1]) {
        //                        high--;
        //                    }
        //                    low++;
        //                    high--;
        //                }
        //                if (sum > 0) {
        //                    high--;
        //                }
        //                if (sum < 0) {
        //                    low++;
        //                }
        //            }
        //        }
        //        System.out.println(result);
        //        return result;
    }
}
