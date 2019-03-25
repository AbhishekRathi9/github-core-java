import java.util.Arrays;

public class CoinChangeTotalWays {

    public static void main(String[] args) {

        int coins[] = {9, 6, 5, 1};
        int value = 11;

        System.out.println(recursiveCCTW(coins, value, 0));
        System.out.println(recursiveCCTWCombination(coins, value));
        System.out.println(recursiveCCTWPermutation(coins, value, 0));
        dynamicCC(coins, value);


    }



    private static void dynamicCC(int[] coins, int value) {
        int[] cache = new int[value + 1];
        cache[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= value; j++) {
                if (coins[i] <= j) {
                    cache[j] += cache[j - coins[i]];
                }
            }
        }
        System.out.println(cache[value]);
    }

    private static int recursiveCCTWPermutation(int[] coins, int value, int index) {

        if (value == 0) {
            return 1;
        }

        if (value < 0) {
            return 0;
        }

        int result = 0;
        for (int i = index; i < coins.length; i++) {
            result += recursiveCCTWPermutation(coins, value - coins[i], i);
        }

        return result;
    }

    private static int recursiveCCTWCombination(int[] coins, int value) {

        if (value == 0) {
            return 1;
        }

        if (value < 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < coins.length; i++) {
            result += recursiveCCTWCombination(coins, value - coins[i]);
        }

        return result;
    }

    private static int recursiveCCTW(int[] coins, int value, int index) {

        if (value == 0) {
            return 1;
        }

        if (value < 0) {
            return 0;
        }
        if (index == coins.length) {
            return 0;
        }

        int include = recursiveCCTW(coins, value - coins[index], index);

        int exclude = recursiveCCTW(coins, value, index + 1);

        return include + exclude;
    }
}
