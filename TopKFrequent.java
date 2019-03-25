import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        topKFrequent(nums, k);
    }

    private static List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
            max = Integer.max(max, map.get(num));
        }

        List<Integer>[] freqArray = new List[max + 1];
        for (int num : map.keySet()) {
            if (freqArray[map.get(num)] == null) {
                freqArray[map.get(num)] = new ArrayList<>();
            }
            freqArray[map.get(num)].add(num);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = freqArray.length - 1; i >= 0 && result.size() < k; i--) {
            if (freqArray[i] != null) {
                result.addAll(freqArray[i]);
            }
        }

        return result;
    }
}
