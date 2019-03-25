import java.util.HashSet;
import java.util.Set;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] strs = {"flower", "flow", "flight"};
        longestCommonPrefix(strs);
    }

    private static String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0){
            return "";
        }
        String longestPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            String currentString = strs[i];
            while (j < longestPrefix.length() && j < currentString.length() && longestPrefix.charAt(j) == currentString.charAt(j)) {
                j++;
            }
            if (j == 0) {
                return "";
            }
            longestPrefix = longestPrefix.substring(0, j);
        }
        System.out.println(longestPrefix);
        return longestPrefix;
    }
}
