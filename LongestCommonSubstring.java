import java.util.Arrays;
import java.util.Stack;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "abde";

        logic(s1, s2);

        int[][] memo = new int[s1.length() + 1][s2.length() + 1];

        System.out.println(recursion(s1, s2, 0, 0, 0, memo));
    }

    private static int recursion(String s1, String s2, int s1Length, int s2Length, int count, int[][] memo) {

        if (memo[s1Length][s2Length] != 0) {
            return memo[s1Length][s2Length];
        }
        if (s1Length == s1.length() || s2Length == s2.length()) {
            return count;
        }
        if (s1.charAt(s1Length) == s2.charAt(s2Length)) {
            count = recursion(s1, s2, s1Length + 1, s2Length + 1, count + 1, memo);
        }
        memo[s1Length][s2Length] = Math.max(count,
                Math.max(recursion(s1, s2, s1Length + 1, s2Length, 0, memo), recursion(s1, s2, s1Length, s2Length + 1, 0,
                        memo)));
        return memo[s1Length][s2Length];
    }

    private static void logic(String s1, String s2) {
        //        int[][] matrix = new int[s1.length() + 1][s2.length() + 1];
        //        int max = Integer.MIN_VALUE;
        //        int maxRowIndex = 0;
        //        for (int i = 0; i <= s1.length(); i++) {
        //            for (int j = 0; j <= s2.length(); j++) {
        //                if (i == 0 || j == 0) {
        //                    matrix[i][j] = 0;
        //                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
        //                    matrix[i][j] = 1 + matrix[i - 1][j - 1];
        //                    if (max < matrix[i][j]) {
        //                        max = matrix[i][j];
        //                        maxRowIndex = i;
        //                    }
        //                } else {
        //                    matrix[i][j] = 0;
        //                }
        //            }
        //        }

        int[][] matrix = new int[s1.length() + 1][s2.length() + 1];
        int max = Integer.MIN_VALUE;
        int maxRowIndex = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    if (max < matrix[i][j]) {
                        max = matrix[i][j];
                        maxRowIndex = i;
                    }
                } else {
                    matrix[i][j] = 0;
                }
            }
        }

        System.out.println(Arrays.deepToString(matrix));
        Stack<Character> stack = new Stack<>();

        while (max != 0) {
            stack.add(s1.charAt(maxRowIndex - 1));
            max--;
            maxRowIndex--;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
