import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinations {

    public static void main(String[] args) {

        letterCombinations("23");

        iterative("23");

        recursive("23");
    }

    private static List<String> recursive(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.equals("")) {
            return result;
        }
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        combinations(digits, mapping, "", result, 0);

        return result;
    }

    private static void combinations(String digits, String[] mapping, String prefix, List<String> result, int offset) {

        if (offset >= digits.length()) {
            result.add(prefix);
            return;
        }
        String letters = mapping[digits.toCharArray()[offset] - '0'];
        for (char c : letters.toCharArray()) {
            combinations(digits, mapping, prefix + c, result, offset + 1);
        }
    }

    private static void iterative(String digits) {
        LinkedList<String> queue = new LinkedList<String>();
        queue.add("");

        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int index = 0;
        for (char digit : digits.toCharArray()) {
            index++;
            while (queue.peek().length() != index) {
                String remove = queue.remove();
                for (char c : mapping[digit - '0'].toCharArray()) {
                    queue.add(remove + c);
                }
            }
        }

        System.out.println(queue);
    }

    private static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.equals("")) {
            return result;
        }
        HashMap<Character, List<Character>> map = new HashMap<>();
        map.put('0', new ArrayList<>());
        map.put('1', new ArrayList<>());
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        StringBuilder sb = new StringBuilder();

        helper(digits, map, sb, result);
        System.out.println(result);
        return result;
    }

    private static void helper(String digits, HashMap<Character, List<Character>> map, StringBuilder sb, List<String> result) {
        if (sb.length() == digits.length()) {
            result.add(new String(sb));
            return;
        }
        for (char c : map.get(digits.charAt(sb.length()))) {
            sb.append(c);
            helper(digits, map, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    //    int i = 0;
    //        for (char digit : digits.toCharArray()) {
    //        i++;
    //        char[] characters = mapping[digit - '0'].toCharArray();
    //        while (queue.peek().length() != i) {
    //            String remove = queue.remove();
    //            for (char c : characters) {
    //                queue.add(remove + c);
    //            }
    //        }
    //    }
}
