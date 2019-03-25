public class FindTheDifference {

    public static void main(String[] args) {

        String s = "abcd";
        String t = "abcde";
        System.out.println(findTheDifference(s, t));
        ;

        System.out.println(findTheDifference2(s, t));
    }

    private static char findTheDifference2(String s, String t) {
        int sum = 0;
        int sum1 = 0;

        for (int n : s.toCharArray()) {
            sum += n;
        }

        for (int n : t.toCharArray()) {
            sum1 += n;
        }

        return (char) (sum1 - sum);
    }

    private static char findTheDifference(String s, String t) {

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            res ^= t.charAt(i);
        }

        return (char)res;
    }
}
