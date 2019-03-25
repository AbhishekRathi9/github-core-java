import java.util.HashMap;
import java.util.Map;

public class MinimumSumPartition {

    // Partition the set S into two subsets S1, S2 such that the
    // difference between the sum of elements in S1 and the sum
    // of elements in S2 is minimized
    public static int minPartition(int[] nums, int index, int firstSet, int secondSet,
            Map<String, Integer> lookUp) {

        if (index == nums.length) {
            return Math.abs(firstSet - secondSet);
        }

        String key = index + "!" + firstSet + secondSet;
        if (lookUp.containsKey(key)) {
            return lookUp.get(key);
        }
        int include = minPartition(nums, index + 1, firstSet + nums[index], secondSet, lookUp);

        int exclude = minPartition(nums, index + 1, firstSet, secondSet + nums[index], lookUp);

        lookUp.put(key, Integer.min(include, exclude));

        return lookUp.get(key);
    }

    // main function
    public static void main(String[] args) {
        // Input: set of items
        int[] nums = {1, 5, 9, 10};
        Map<String, Integer> lookUp = new HashMap<>();
        System.out.println("The minimum difference is "
                + minPartition(nums, 0, 0, 0, lookUp));
    }
}
