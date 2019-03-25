public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "abbbca";
        //  System.out.println(longestPalindrome(s));
        System.out.println(longestPalindromeii(s));
        ;

        // System.out.println(s.substring(1, 2));
    }

    private static String longestPalindromeii(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int length = s.length();
        boolean[][] isPalindrome = new boolean[length][length];
        int left = 0;
        int right = 0;

        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                boolean isInnerWordPalindrome = isPalindrome[i + 1][j - 1] || j-i <= 2;

                if (s.charAt(i) == s.charAt(j) && isInnerWordPalindrome) {
                    isPalindrome[i][j] = true;
                    if (j-i > right - left) {
                        right = j;
                        left = i;
                    }
                }
            }
        }

        return s.substring(left, right + 1);
    }

    private static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int size = s.length();
        boolean[][] matrix = new boolean[size][size];
        int beginsAt = 0;
        int maxLenth = 1;

        for (int i = 0; i < size; i++) {
            matrix[i][i] = true;
        }

        for (int i = 0; i < size - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                matrix[i][i + 1] = true;
                beginsAt = i;
                maxLenth = 2;
            }
        }

        for (int length = 3; length <= size; length++) {
            for (int i = 0; i < size - length + 1; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j) && matrix[i + 1][j - 1]) {
                    matrix[i][j] = true;
                    beginsAt = i;
                    maxLenth = length;
                }
            }
        }
        return s.substring(beginsAt, beginsAt + maxLenth);
    }
}
