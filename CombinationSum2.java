import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public static void main(String[] args) {

        int[] candidates = {2, 5, 1, 2};

        combinationSum2(candidates, 5);
    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        List<Integer> step = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumHelper2(result, step, candidates, target, 0);
        System.out.println(result);
        return result;
    }

    private static void combinationSumHelper2(List<List<Integer>> result, List<Integer> step, int[] candidates,
            int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(step));
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                return;
            }
            step.add(candidates[i]);
            combinationSumHelper2(result, step, candidates, target - candidates[i], i + 1);
            step.remove(step.size() - 1);
        }
    }
}
