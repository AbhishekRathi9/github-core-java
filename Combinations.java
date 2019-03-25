import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        String str = "3";

       //  combination1("", str, 0);
        List<Character> result = new ArrayList<>();
         combination2recursion(str, result, 0); //similar to knapsack
       // List<Character> step = new ArrayList<>();
       // List<List<Character>> btResult = new ArrayList<>();
       // combinationBacktrack(str, step, btResult, 0);

    }


    private static void combinationBacktrack(String str, List<Character> step, List<List<Character>> btResult, int index) {

        btResult.add(new ArrayList<>(step));

        for (int i = index; i < str.length(); i++) {
            step.add(str.charAt(i));
            combinationBacktrack(str, step, btResult, i + 1);
            step.remove(step.size() - 1);
        }
        System.out.println(btResult);
    }

    private static void combination2recursion(String str, List<Character> result, int index) {

        if (index >= str.length()) {
            System.out.println(result);
            return;
        }
        result.add(str.charAt(index));
        combination2recursion(str, result, index + 1);
        result.remove(result.size() - 1);
        combination2recursion(str, result, index + 1);
    }

    private static void combination1(String result, String str, int index) {
        if (index >= str.length()) {
            System.out.println(result);
            return;
        }
        combination1(result + str.charAt(index), str, index + 1);
        combination1(result, str, index + 1);
    }
}
