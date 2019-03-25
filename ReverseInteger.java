public class ReverseInteger {

    public static void main(String[] args) {
        int x = 120676676;
        reverse(x);
    }

    private static int reverse(int x) {
        int reverse = 0;
        int resultCopy = reverse;
        while (x != 0) {
            int rem = x % 10;
            reverse = reverse * 10 + rem;
            if ((reverse ) / 10 != resultCopy) {
                return 0;
            }
            resultCopy = reverse;
            x = x / 10;
        }
        System.out.println(reverse);
        return reverse;
    }

    public static  int reverse1(int x)
    {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }
        System.out.println(result);
        return result;
    }
}
