public class ShortestCommonSuperSequence {

    public static void main(String[] args) {
        String s1 = "AB";
        String s2 = "AC";
        System.out.println(recursiveSCS(s1, s2, 0, 0));;
    }

    private static int recursiveSCS(String s1, String s2, int s1Index, int s2Index) {

        if (s1Index == s1.length()-1) {
            return s2.length();
        }

        if (s2Index == s2.length()-1) {
            return s1.length();
        }
        if (s1.charAt(s1Index) == s2.charAt(s2Index)) {
            return 1 + recursiveSCS(s1, s2, s1Index + 1, s2Index + 1);
        } else {
            return 1 + Integer.min(recursiveSCS(s1, s2, s1Index + 1, s2Index), recursiveSCS(s1, s2, s1Index, s2Index + 1));
        }
    }
}
