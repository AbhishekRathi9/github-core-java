public class PatternSearch {

    public static void main(String[] args) {

        String text = "abcbcfg";
        String pattern = "bcfg";

        for (int i = 0; i < text.length(); i++) {
            int temp = 0;
            for (int j = 0; j < pattern.length(); j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
                temp++;
            }

            if (temp == pattern.length()) {
                System.out.println("index is -->" + i);
            }
        }
    }
}
