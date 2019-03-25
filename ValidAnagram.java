public class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println( isAnagram(s, t));;
    }

    private static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] array = new int[26];

        for (char c : s.toCharArray()) {
            array[c - 'a'] = array[c - 'a'] + 1;
        }

        for (char c : t.toCharArray()) {
            array[c - 'a'] = array[c - 'a'] - 1;
            if (array[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
