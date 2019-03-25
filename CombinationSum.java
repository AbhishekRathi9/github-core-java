import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

        int[] candidates = {1,2,3};
        combinationSum(candidates, 4);
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        List<Integer> step = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumHelper(result, step, candidates, target, 0);
        System.out.println(result);
        return result;
    }

    private static void combinationSumHelper(List<List<Integer>> result, List<Integer> step, int[] candidates,
            int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(step));
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            step.add(candidates[i]);
            combinationSumHelper(result, step, candidates, target - candidates[i], i);
            step.remove(step.size() - 1);
        }
    }
}
