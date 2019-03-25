import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ThirdMaxInArray {

    public static void main(String[] args) {
        int nums[] = {1, 5, 9, 1, 5, 9};
        //int nums[] = {5,3,7};
        System.out.println(findThirdMax(nums));
        System.out.println(containsDuplicate(nums));
        System.out.println(containsNearbyDuplicate(nums, 3));
        System.out.println(containsNearbyDuplicateSlidingWindow(nums, 2));

        System.out.println(containsNearbyAlmostDuplicate(nums, 2, 3));
        ;
    }

    private static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length <= 0 || k <= 0) {
            return false;
        }
        final TreeSet<Integer> values = new TreeSet<>();

        for (int ind = 0; ind < nums.length; ind++) {

            Integer ceiling = values.ceiling(nums[ind]);
            Integer floor = values.floor(nums[ind]);

            if ((ceiling != null && ceiling <= nums[ind] + t) || (floor != null && floor >= nums[ind] - t)) {
                return true;
            }

            values.add(nums[ind]);
            if (ind >= k) {
                values.remove(nums[ind - k]);
            }
        }

        return false;
    }

    private static boolean containsNearbyDuplicateSlidingWindow(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {

            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                Integer index = map.get(nums[i]);
                if (i - index <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {

            set.add(n);
        }

        return set.size() != nums.length;
    }

    private static int findThirdMax(int[] nums) {

        Integer highest = null;
        Integer centre = null;
        Integer lowest = null;

        for (int i = 0; i < nums.length; i++) {

            if (highest == null || nums[i] >= highest) {
                if (highest != null && nums[i] == highest) {
                    continue;
                }
                lowest = centre;
                centre = highest;
                highest = nums[i];
            } else if (centre == null || nums[i] >= centre) {
                if (centre != null && nums[i] == centre) {
                    continue;
                }
                lowest = centre;
                centre = nums[i];
            } else if (lowest == null || nums[i] > lowest) {
                lowest = nums[i];
            }
        }
        return lowest == null ? highest : lowest;
    }
}
