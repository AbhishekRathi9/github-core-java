import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {

    public static void main(String[] args) {

        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
        System.out.println(firstUniqCharii(s));
    }

    private static int firstUniqCharii(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (frequency[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    private static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (!map.containsKey(curr)) {
                map.put(curr, i);
            } else {
                map.put(curr, -1);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int value : map.values()) {
            if (value != -1 && value < min) {
                min = value;
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
