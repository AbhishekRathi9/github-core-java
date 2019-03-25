import java.util.ArrayList;
import java.util.List;

public class DisAppearedNumber {

    public static void main(String[] args) {
        int[] numbers = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(numbers));
        ;
    }

    private static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int n : nums) {
            int index = Math.abs(n) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
