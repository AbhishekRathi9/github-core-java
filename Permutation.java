import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        String str = "abc";

        permute(number, 0);
        List<List<Character>> lists = permuteBackTrack(str.toCharArray());
        System.out.println(lists);
    }

    private static void permute(int[] number, int index) {

        if (index == number.length) {
            System.out.println(Arrays.toString(number));
            return;
        }
        for (int i = index; i < number.length; i++) {
            // boolean check = shouldSwap(number, index, i);
            // if (check) {
            swap(number, index, i);
            permute(number, index + 1);
            swap(number, index, i);
            // }
        }
    }

    // private static boolean shouldSwap(int[] number, int index, int curr) {

    // }

    private static void swap(int[] number, int i, int start) {

        int temp = number[i];
        number[i] = number[start];
        number[start] = temp;
    }

    public static List<List<Character>> permuteBackTrack(char[] nums) {
        List<List<Character>> result = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private static void backtrack(List<List<Character>> result, ArrayList<Character> step, char[] nums) {

        if (step.size() == nums.length) {
            result.add(new ArrayList<>(step));
        }

        for (int i = 0; i < nums.length; i++) {
            if (step.contains(nums[i])) {
                continue;
            }
            step.add(nums[i]);
            backtrack(result, step, nums);
            step.remove(step.size() - 1);
        }
    }
}
