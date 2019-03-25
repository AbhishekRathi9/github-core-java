import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharacterByFrequency {

    public static void main(String[] args) {

        String s = "tree";

        frequencySort(s);
    }

    private static String frequencySort(String s) {
        if (s == null) {
            return "";
        }

        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (char c : charArray) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
            max = Integer.max(max, map.get(c));
        }

        List[] frequencyArray = new ArrayList[max + 1];

        for (Character c : map.keySet()) {
            int count = map.get(c);
            if (frequencyArray[count] == null) {
                frequencyArray[count] = new ArrayList<>();
            }
            frequencyArray[count].add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = frequencyArray.length - 1; i >= 0; i--) {
            if (frequencyArray[i] != null) {
                List<Character> list = frequencyArray[i];
                for (Character c : list) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}
