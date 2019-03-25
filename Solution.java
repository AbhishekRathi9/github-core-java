import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        int[] array = {1,2,3,6,7,8,9,1};
        long number =10;
        findpairs(array,number);
    }

    private static int findpairs(int[] nums, long k) {
        Integer ik = (int) (long) k;
        if (nums == null || nums.length == 0 || k < 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (ik == 0) {
                //count how many elements in the array that appear more than twice.
//                if (entry.getValue() >= 2) {
//                    count++;
//                }
            } else {
                if (map.containsKey(ik-entry.getKey())) {
                    count++;
                }
            }
        }
        System.out.println(count);
        return count;
    }
    }


