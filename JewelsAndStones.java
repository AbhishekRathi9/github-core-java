import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";

        numJewelsInStones(J, S);
    }

    private static int numJewelsInStones(String j, String s) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < j.length(); i++) {
            set.add(j.charAt(i));
        }
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                count++;
            }
        }

        return count;
    }
}
