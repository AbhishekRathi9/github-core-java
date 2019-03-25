import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
        System.out.println(groupAnagramsBetterApproach(strs));
    }

    private static List<List<String>> groupAnagramsBetterApproach(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] arr = new int[26];
            for (int i = 0; i < s.length(); i++) {
                arr[s.charAt(i) - 'a']++;
            }
            map.computeIfAbsent(Arrays.toString(arr), key -> new ArrayList<>()).add(s);
        }
        return new LinkedList<>(map.values());
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] current = s.toCharArray();
            Arrays.sort(current);
            String s1 = Arrays.toString(current);

            List<String> tempList = map.getOrDefault(s1, new LinkedList<String>());
            tempList.add(s);
            map.put(s1, tempList);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
