import java.util.HashMap;
import java.util.Map;

public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        int[] numbers = {1, 4, 20, 3, 10, 5};
        int target = 3;

        System.out.println(subArraySum(numbers, target));
        ;
    }

    private static boolean subArraySum(int[] numbers, int target) {
        int start = 0;
        int end = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int runningSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            runningSum = runningSum + numbers[i];
            if (map.containsKey( runningSum-target)) {
                end = i;
                start = map.get(runningSum-target)+1;
                System.out.println(start);
                System.out.println(end);
                return true;
            }
            map.put(runningSum, i);
        }

        return false;
    }
}
