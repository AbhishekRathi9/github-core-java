import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ParenthesisMatch {

    private static final HashMap<Character, Character> parenthesisMap = new HashMap<>();
    private static final Set<Character> openingParenthesis = new HashSet<>();

    public static void main(String[] args) {
        String word = "abc{sd[fdf(dfd)(fdd]}";
        parenthesisMap.put('{', '}');
        parenthesisMap.put('[', ']');
        parenthesisMap.put('(', ')');
        openingParenthesis.addAll(parenthesisMap.keySet());

        System.out.println(isBalanced(word));
    }

    private static boolean isBalanced(String word) {
        Stack<Character> stack = new Stack<>();
        for (Character c : word.toCharArray()) {
            if (openingParenthesis.contains(c)) {
                stack.add(c);
            } else {
                if (parenthesisMap.values().contains(c)) {
                    if (parenthesisMap.get(stack.pop()) != c) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
