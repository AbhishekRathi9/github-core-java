public class ReverseString {

    public static void main(String[] args) {
         String s = "A man, a plan, a canal: Panama";
       // String s = "hello";
        System.out.println(reverseString(s));;
    }

    private static String reverseString(String s) {
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
}
