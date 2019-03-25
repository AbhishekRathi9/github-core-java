import java.util.Arrays;

public class EditDistance {

    public static void main(String[] args) {
        String str1 = "kitten";
        String str2 = "sitting";
        int[][] memo = new int[str1.length() + 1][str2.length() + 1];
        System.out.println(recursionED(str1, str2, str1.length(), str2.length(), memo));
        dynamicED(str1, str2);

    }

    private static void dynamicED(String str1, String str2) {
        int[][] matrix = new int[str1.length() + 1][str2.length() + 1];

        for (int row = 0; row <= str1.length(); row++) {
            for (int column = 0; column <= str2.length(); column++) {
                if (row == 0) {
                    matrix[row][column] = column;
                } else if (column == 0) {
                    matrix[row][column] = row;
                } else if (str1.charAt(row - 1) == str2.charAt(column - 1)) {
                    matrix[row][column] = matrix[row - 1][column - 1];
                } else {
                    matrix[row][column] = 1 + Integer.min(Integer.min(matrix[row - 1][column - 1], matrix[row][column - 1]),
                            matrix[row-1][column]);
                }
            }
        }
        System.out.println( Arrays.deepToString(matrix));
    }

    private static int recursionED(String str1, String str2, int s1Length, int s2Length, int[][] memo) {
        if (memo[s1Length][s2Length] != 0) {
            return memo[s1Length][s2Length];
        }
        if (s1Length == 0) {
            return s2Length;
        }
        if (s2Length == 0) {
            return s1Length;
        }
        if (str1.charAt(s1Length - 1) == str2.charAt(s2Length - 1)) {
            memo[s1Length][s2Length] = recursionED(str1, str2, s1Length - 1, s2Length - 1, memo);
            return memo[s1Length][s2Length];
        } else {
            int add = recursionED(str1, str2, s1Length, s2Length - 1, memo);
            int del = recursionED(str1, str2, s1Length - 1, s2Length, memo);
            int replace = recursionED(str1, str2, s1Length - 1, s2Length - 1, memo);

            memo[s1Length][s2Length] = 1 + Integer.min(Integer.min(add, del), replace);
            return memo[s1Length][s2Length];
        }
    }
}
