import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy(n));
        System.out.println(isHappy2(n));
        ;
    }

    private static boolean isHappy2(int n) {

        Set<Integer> set = new HashSet<>();
        int sum = 0;
        while (set.add(n)) {
            sum = getSum(n);
            n = sum;
        }
        if (n == 1) {
            return true;
        }
        return false;
    }

    private static boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while (fast != 1) {

            fast = getSum(fast);
            fast = getSum(fast);
            slow = getSum(slow);
            if (slow == fast) {
                break;
            }
        }

        return fast == 1;
    }

    private static int getSum(int n) {
        int sum = 0;
        while (n != 0) {
            int rem = n % 10;
            sum += rem * rem;
            n = n / 10;
        }
        return sum;
    }

    public boolean isHappy1(int n) {
        int slow = n, fast = n;
        while (fast != 1) {
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
            slow = digitSquareSum(slow);
            if (slow == fast) {
                break;
            }
        }
        return fast == 1;
    }

    private int digitSquareSum(int n) {
        int res = 0;
        while (n != 0) {
            res += (n % 10) * (n % 10);
            n /= 10;
        }
        return res;
    }
}
