import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakproblem {

    public static void main(String[] args) {

        //        List<String> dictionary = Arrays.asList("this", "th", "is", "famous", "Word", "break",
        //                "b", "r", "e", "a", "k", "br", "bre", "brea", "ak", "problem");

        List<String> dictionary = Arrays.asList("l","e","e","t", "code");

        // input String
        String str = "leetcode";
        //                String s = "l";
        //                System.out.println(s.substring(0,1));
        //                System.out.println(s.substring(1));
        System.out.println(recursiveWBP(dictionary, str));
        System.out.println(dynamicWP(dictionary, str));
    }

    private static boolean dynamicWP(List<String> dict, String s) {

        boolean[] cache = new boolean[s.length() + 1];
        cache[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (cache[j] && dict.contains(s.substring(j, i))) {
                    cache[i] = true;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(cache));
        return cache[s.length()];
    }

    private static boolean recursiveWBP(List<String> dictionary, String str) {
        Map<String, Boolean> map = new HashMap<>();
        return helper(dictionary, str);
    }

    private static boolean helper(
            List<String> dictionary, String str) {

        if (str.length() == 0) {
            return true;
        }
        for (int i = 1; i <= str.length(); i++) {
            String firstHalf = str.substring(0, i);
            String secondHalf = str.substring(i);
            if (dictionary.contains(firstHalf)) {
                if (helper(dictionary, secondHalf)) {
                    return true;
                }
            }
        }

        return false;
    }
}
