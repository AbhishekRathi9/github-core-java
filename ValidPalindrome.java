public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "P";
        //  System.out.println(validPalindrome(s));
        // System.out.println(validPalindromeii("abca"));
        System.out.println(palindromeNumber(121));
    }

    private static boolean palindromeNumber(int x) {
        if (x < 0) {
            return false;
        }
        if (x > 0 && x % 10 == 0) {
            return false;
        }

        int reverse = 0;
        while (x > reverse) {
            int rem = x % 10;
            reverse = reverse * 10 + rem;
            x = x / 10;
        }
        return x == reverse || reverse/10==x;
    }

    private static boolean validPalindromeii(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
        }

        return true;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            while (i <= j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (i <= j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
