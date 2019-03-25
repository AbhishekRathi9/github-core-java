import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};

        fourSum(nums,0);
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int low = j + 1;
                int high = nums.length - 1;
                int sum = 0;
                while (low < high) {
                    sum = nums[i] + nums[j] + nums[low] + nums[high]-target;
                    if (sum == 0) {
                        List<Integer> quarplet = new ArrayList<>();
                        quarplet.add(nums[i]);
                        quarplet.add(nums[j]);
                        quarplet.add(nums[low]);
                        quarplet.add(nums[high]);
                        result.add(quarplet);

                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        high--;
                        low++;
                    }
                    if (sum > 0) {
                        high--;
                    }
                    if (sum < 0) {
                        low++;
                    }
                }
            }
        }
        System.out.println(result);
        return result;
    }
}
