import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {

        int[] nums = {1, 2, 2};
        // System.out.println(subsets(nums));
        System.out.println(subsetsii(nums));
        ;
    }

    private static List<List<Integer>> subsetsii(int[] nums) {
        List<Integer> step = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsetsHelperii(nums, step, result, 0);
       // System.out.println(result);
        return result;
    }

    private static void subsetsHelperii(int[] nums, List<Integer> step, List<List<Integer>> result, int index) {

        result.add(new ArrayList<>(step));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            step.add(nums[i]);
            subsetsHelperii(nums, step, result, i + 1);
            step.remove(step.size() - 1);
        }
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<Integer> step = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        subsetsHelper(nums, step, result, 0);
        return result;
    }

    private static void subsetsHelper(int[] nums, List<Integer> step, List<List<Integer>> result, int index) {

        result.add(new ArrayList<>(step));
        for (int i = index; i < nums.length; i++) {
            step.add(nums[i]);
            subsetsHelper(nums, step, result, i + 1);
            step.remove(step.size() - 1);
        }
    }
}
