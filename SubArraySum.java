import java.util.HashMap;
import java.util.Map;

public class SubArraySum {

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        System.out.println(subarraySum(nums, 2));
    }

    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int result = 0;
        Map<Integer, Integer> presum = new HashMap<>();
        presum.put(0,1);
        for (int n : nums) {
            sum = sum + n;
            if (presum.containsKey(sum - k)) {
                result++;
            }
            presum.put(sum, presum.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}

