public class PowerOfTwo {

    public static void main(String[] args) {
        int n = 15;
        System.out.println(isPowerOfTwo(n));
        ;
    }

    private static boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n = n / 2;
        }
        return n == 1;
    }
}
