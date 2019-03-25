public class ReverseVowels {

    public static void main(String[] args) {

        String s = "Let's take LeetCode contest";
        // System.out.println(reverseVowels(s));
        ;
       // System.out.println(reverseWords(s));
        System.out.println(reverseWordsWithoutSplit(s));
        ;
    }

    private static String reverseWordsWithoutSplit(String s) {
        char[] characters = s.toCharArray();
        int start = 0;
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == ' ') {
                reverseWord(characters, start, i - 1);
                start = i + 1;
            }
        }
        reverseWord(characters,start,characters.length-1);
        return new String(characters);
    }

    private static void reverseWord(char[] characters, int start, int end) {
        while (start < end) {
            char temp = characters[start];
            characters[start] = characters[end];
            characters[end] = temp;
            start++;
            end--;
        }
    }

    private static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            String reverse = reverse(word);
            sb.append(reverse);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static String reverse(String s) {
        char[] c = s.toCharArray();

        int i = 0;
        int j = c.length - 1;

        while (i < j) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
        return new String(c);
    }

    private static String reverseVowels(String s) {
        char[] characters = s.toCharArray();

        int i = 0;
        int j = characters.length - 1;

        while (i < j) {

            char characterStart = characters[i];
            char characterEnd = characters[j];

            if (isVowel(characterStart) && isVowel(characterEnd)) {
                char temp = characters[i];
                characters[i] = characters[j];
                characters[j] = temp;
                i++;
                j--;
            } else if (isVowel(characterStart)) {
                j--;
            } else if (isVowel(characterEnd)) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return new String(characters);
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'o' || c == 'i' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
