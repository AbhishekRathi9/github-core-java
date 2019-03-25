import java.util.Arrays;

public class CoinChangeMin {

    public static void main(String[] args) {

        int coins[] = {9, 6, 5, 1};
        int value = 11;

        System.out.println(recursion(coins, value, 0));
        System.out.println(recursionii(coins, value, 0));
        System.out.println(dynamic(coins, value));
        ;
    }

    private static int dynamic(int[] coins, int value) {

        int[] cache = new int[value + 1];

        Arrays.fill(cache, 9999);
        cache[0] = 0;
        for (int i = 1; i <= value; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    cache[i] = Integer.min(cache[i], 1 + cache[i - coins[j]]);
                }
            }
        }

        System.out.println(Arrays.toString(cache));
        return cache[value];
    }

    private static int recursionii(int[] coins, int value, int index) {
        if (value < 0) {
            return 99999;
        }
        if (value == 0) {
            return 0;
        }

        if (index >= coins.length) {
            return 99999;
        }

        int include = 1 + recursion(coins, value - coins[index], index);
        int exclude = recursion(coins, value, index + 1);

        return Integer.min(include, exclude);
    }

    private static int recursion(int[] coins, int value, int index) {

        if (index >= coins.length) {
            return 9999999;
        }
        if (value < 0) {
            return 9999999;
        }

        if (value == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = index; i < coins.length; i++) {
            min = Integer.min(min, 1 + recursion(coins, value - coins[i], i));
        }

        return min;
    }
}
