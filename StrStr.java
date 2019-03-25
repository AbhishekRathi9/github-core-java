public class StrStr {

    public static void main(String[] args) {

        String haystack = "goodtecher";
        String needle = "tech";

        System.out.println(strStr(haystack, needle));
        ;
    }

    private static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
