import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class KDiffPair {

    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int diff = 1;

        findPair(numbers, diff);
        findPairWithMap(numbers, diff);
    }

    private static int findPairWithMap(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Set<Integer> integers = map.keySet();

        int count = 0;

        for (int n : integers) {
            if (k == 0) {
                if (map.get(n) >= 2) {
                    count++;
                }
            } else {
                if (map.containsKey(n + k)) {
                    count++;
                }
            }
        }
        System.out.println(count);
        return count;
    }

    private static int findPair(int[] numbers, int k) {

        Arrays.sort(numbers);
        int size = numbers.length;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < size; j++) {
                if (j != i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }
                if (numbers[j] - numbers[i] == k) {
                    count++;

                    System.out.println(numbers[i] + " : " + numbers[j]);
                }
            }
        }

        System.out.println(count);
        return count;
    }
}
