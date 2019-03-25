import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "pwwkew";
         System.out.println(lengthOfLongestSubstring(s));
       // System.out.println(lengthOfLongestSubstringUsingArray(s));

         //lengthOfLongestSubstringWith2DistinctCharacters(s);
    }

    private static int lengthOfLongestSubstringUsingArray(String s) {
        int start = 0;
        int end = 0;
        int diff = 0;
        int counter = 0;

        int[] hash = new int[128];

        while (end < s.length()) {

            char c1 = s.charAt(end);
            hash[c1]++;
            if (hash[c1] > 1) {
                counter++;
            }
            end++;

            while (counter != 0) {
                char c2 = s.charAt(start);
                hash[c2]--;
                if (hash[c2] > 0) {
                    counter--;
                }
                start++;
            }
            diff = Integer.max(diff, end - start);
        }
        return diff;
    }

    private static void lengthOfLongestSubstringWith2DistinctCharacters(String s) {
        Map<Character, Integer> prefixMap = new HashMap<>();

        int start = 0;
        int end = 0;
        int diff = 0;

        while (end < s.length()) {
            char temp = s.charAt(end);
            prefixMap.put(temp, prefixMap.getOrDefault(temp, 0) + 1);
            end++;

            while (prefixMap.size() > 2) {
                char tempVar = s.charAt(start);
                prefixMap.put(tempVar, prefixMap.getOrDefault(tempVar, 0) - 1);
                if (prefixMap.get(tempVar) == 0) {
                    prefixMap.remove(tempVar);
                }
                start++;
            }
            diff = Integer.max(diff, end - start);
        }
        System.out.println(diff);
    }

    private static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int counter = 0;
        int result = 0;
        while (end < s.length()) {
            char temp = s.charAt(end);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            if (map.get(temp) > 1) {
                counter++;
            }
            end++;

            while (counter == 1) {
                char character = s.charAt(start);
                map.put(character, map.getOrDefault(character, 0) - 1);
                if (map.get(character) == 1) {
                    counter--;
                }
                start++;
            }
            result = Integer.max(result, end - start);
        }
        return result;
    }
}
