public class NumberReversal {

    public static void main(String[] args) {
        int number = 12345;

        //reverseIteratively(number);
        reverserecursively(number);
    }

    private static void reverserecursively(int number) {
        if (number < 10) {
            System.out.println(number);
            return;
        }
        System.out.println(number % 10);
        number = number / 10;
        reverserecursively(number);
    }

    private static void reverseIteratively(int number) {
        int reverse = 0;

        while (number > 0) {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number / 10;
        }
        System.out.println(reverse);
    }
}
