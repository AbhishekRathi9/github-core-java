public class AdStrings {

    public static void main(String[] args) {
        String num1 = "408";
        String num2 = "5";

        System.out.println( addStrings(num1, num2));;
    }

    private static String addStrings(String num1, String num2) {

        char[] characters1 = num1.toCharArray();
        char[] characters2 = num2.toCharArray();
        int carry = 0;
        int i = characters1.length - 1;
        int j = characters2.length - 1;
        StringBuilder sb = new StringBuilder();
        int sum = 0;

        while (i >= 0 || j >= 0) {
            int digit1 = 0;
            int digit2 = 0;
            if (i >= 0) {
                digit1 = characters1[i] - '0';
                i--;
            }
            if (j >= 0) {
                digit2 = characters2[j] - '0';
                j--;
            }
            sum = digit1 + digit2 + carry;

                carry = sum / 10;

           sum =  sum%10;
            sb.insert(0, sum);
        }

        if (carry != 0) {
            sb.insert(0, carry);
        }

        return sb.toString();
    }
}
