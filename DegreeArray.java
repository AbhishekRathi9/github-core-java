import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DegreeArray {

    public static void main(String[] args) {

        int[] nums = {-1,-2,-3};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        findShortestSubArray(nums);
    }

    private static int findShortestSubArray(int[] nums) {

        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[]{1, i, i});
            } else {
                int[] values = map.get(nums[i]);
                values[0] = values[0]+1;
                values[2] = i;
            }
        }

        int maxLength = 0;
        int maxDegree = 0;
        for (int i = 0; i < nums.length; i++) {
            int[] values = map.get(nums[i]);
            if (maxDegree <= values[0]) {
                maxDegree = values[0];
                maxLength = Integer.max(maxLength, values[2] - values[1] + 1);
            }
        }
        System.out.println(maxLength);
        return maxLength;
    }
}
