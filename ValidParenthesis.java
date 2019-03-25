import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {

        String s = "]";
        System.out.println(isValid(s));;
    }

    private static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            if (map.containsKey(c)) {
                if(stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                if (map.get(c) != pop) {
                    return false;
                }
            } else {
                stack.add(c);
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
