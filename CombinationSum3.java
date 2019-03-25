import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    public static void main(String[] args) {

        combinationSum3(3, 9);
    }

    private static List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> step = new ArrayList<>();
        combinationSumHelper2(result, step, n, 1, k);
        System.out.println(result);
        return result;
    }

    private static void combinationSumHelper2(List<List<Integer>> result, List<Integer> step,
            int target, int index, int allowedNumbers) {
        if (target == 0 && allowedNumbers == step.size()) {
            result.add(new ArrayList<>(step));
            return;
        }
        if (target < 0 || step.size()==allowedNumbers) {
            return;
        }
        for (int i = index; i <= 9; i++) {

            if (i > target) {
                break;
            }
            step.add(i);

            combinationSumHelper2(result, step, target - i, i + 1, allowedNumbers);
            step.remove(step.size() - 1);
        }
    }
}
