import java.util.Stack;

public class BackSpaceCompare {

    public static void main(String[] args) {
        String s = "y#fo##f";
        String t = "y#f#o##f";

        System.out.println(backspaceCompare(s, t));
        System.out.println(backspaceCompare2(s, t));

        ;
    }

    private static boolean backspaceCompare2(String s, String t) {

        String string1 = getString(s);
        String string2 = getString(t);

        return string1.equals(string2);
    }

    private static String getString(String s) {
        StringBuilder sb1 = new StringBuilder();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '#') {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    sb1.append(ch);
                }
            }
        }
        return sb1.toString();
    }

    private static boolean backspaceCompare(String s, String t) {

        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!s1.isEmpty()) {
                    s1.pop();
                }
            } else {
                s1.add(c);
            }
        }

        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (!s2.isEmpty()) {
                    s2.pop();
                }
            } else {
                s2.add(c);
            }
        }

        if (s1.size() != s2.size()) {
            return false;
        }

        if (s1.isEmpty()) {
            return true;
        }
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.pop() != s2.pop()) {
                return false;
            }
        }
        return true;
    }
}
