import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramInString {

    public static void main(String[] args) {

        String s = "baa";
        String p = "aa";

        findAnagrams(s, p);
    }

    private static List<Integer> findAnagrams(String s, String p) {
        int i = 0;
        int j = 0;

        List<Integer> result = new ArrayList<>();

        if (s.length() == 0 || p.length() == 0 || s.length() < p.length()) {
            return result;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        while (j < s.length()) {
            char temp = s.charAt(j);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) - 1);
                if (map.get(temp) == 0) {
                    counter--;
                }
            }
            j++;

            while (counter == 0) {
                char character = s.charAt(i);
                if (map.containsKey(character)) {
                    map.put(character, map.get(character) + 1);
                    if (map.get(character) > 0) {
                        counter++;
                    }
                }
                i++;
                if (j - i + 1 == p.length()) {
                    result.add(i - 1);
                }
            }
        }
        System.out.println(result);
        return result;
    }
}
