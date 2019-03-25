import java.util.ArrayList;
import java.util.List;

public class FindDuplicatesInArray {

    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        System.out.println(findDuplicates(nums));
        ;
    }

    private static List<Integer> findDuplicates(int[] nums) {

        List<Integer> result = new ArrayList<>();
        for (int n : nums) {
            int index = Math.abs(n) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            } else {
                result.add(Math.abs(n));
            }
        }

        return result;
    }
}
