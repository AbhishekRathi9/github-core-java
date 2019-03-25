import java.util.Arrays;

public class LongestCommonSubSequence {

    public static void main(String[] args) {

        String s1 = "abcd";
        String s2 = "abcd";
        int[][] mem = new int[s1.length() + 1][s2.length() + 1];
        int recursion = recursion(s1, s2, 0, 0, mem);

        System.out.println(recursion);
        dynamic(s1, s2);
    }

    private static int recursion(String s1, String s2, int s1Length, int s2Length, int[][] mem) {
        if (mem[s1Length][s2Length] != 0) {
            return mem[s1Length][s2Length];
        }
        if (s1Length == s1.length() || s2Length == s2.length()) {
            return 0;
        }
        if (s1.charAt(s1Length) == s2.charAt(s2Length)) {
            mem[s1Length][s2Length] = 1 + recursion(s1, s2, s1Length + 1, s2Length + 1, mem);
            return mem[s1Length][s2Length];
        } else {
            mem[s1Length][s2Length] = Math.max(recursion(s1, s2, s1Length + 1, s2Length, mem),
                    recursion(s1, s2, s1Length, s2Length + 1, mem));
            return mem[s1Length][s2Length];
        }
    }

    private static void dynamic(String s1, String s2) {
        int[][] matrix = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }

        System.out.println(Arrays.deepToString(matrix));

        int result = matrix[s1.length()][s2.length()];
        System.out.println(result);

        int row = s1.length();
        int column = s2.length();

        while (row != 0 && column != 0) {
            if (result == matrix[row - 1][column]) {
                row = row - 1;
            } else if (result == matrix[row][column - 1]) {
                column = column - 1;
            } else {
                System.out.println(s2.charAt(column - 1));
                row = row - 1;
                column = column - 1;
                result = matrix[row][column];
            }
        }
    }

    //print Recursively
    private static void print(int[][] matrix, int s1Length, int s2Length, String s1, String s2) {
        if (s1Length == 0 || s2Length == 0) {
            return;
        } else if (s1.charAt(s1Length - 1) == s2.charAt(s2Length - 1)) {
            print(matrix, s1Length - 1, s2Length - 1, s1, s2);
            System.out.println(s1.charAt(s1Length - 1));
        } else if (matrix[s1Length - 1][s2Length] > matrix[s1Length][s2Length - 1]) {
            print(matrix, s1Length - 1, s2Length, s1, s2);
        } else {
            print(matrix, s1Length, s2Length - 1, s1, s2);
        }
    }
}
