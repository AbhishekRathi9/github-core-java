import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int coins[] = {9, 6, 5, 1};
        int value = 11;
        int[] cache = new int[value + 1];
        int[] trace = new int[value + 1];
        System.out.println(recursionMCC(coins, value, cache, trace));
        System.out.println(Arrays.toString(trace));
        print(trace, value);
        int[] lookUp = new int[value + 1];
        dynamicMCC(coins, value, lookUp, trace);
        System.out.println(Arrays.toString(lookUp));
        System.out.println(Arrays.toString(trace));
        print(trace, value);
    }

    private static void dynamicMCC(int[] coins, int value, int[] lookUp, int[] trace) {

//        int[] cache = new int[value + 1];
        //
        //        Arrays.fill(cache, 9999);
        //        cache[0] = 0;
        //        for (int i = 1; i <= value; i++) {
        //            for (int j = 0; j < coins.length; j++) {
        //                if (coins[j] <= i) {
        //                    cache[i] = Integer.min(cache[i], 1 + cache[i - coins[j]]);
        //                }
        //            }
        //        }
        //
        //        System.out.println(Arrays.toString(cache));
        //        return cache[value];
        for (int i = 1; i <= value; i++) {
            int q = 99999;
            for (int j = 0; j < coins.length; j++) {

                if (coins[j] > i) {
                    continue;
                }
                int cost = 1 + lookUp[i - coins[j]];
                if (cost < q) {
                    q = cost;
                    trace[i] = coins[j];
                }
            }
            lookUp[i] = q;
        }
    }

    private static void print(int[] trace, int value) {
        if (value <= 0) {
            return;
        }
        System.out.println(trace[value]);
        print(trace, value - trace[value]);
    }

    private static int recursionMCC(int[] coins, int value, int[] cache, int[] trace) {

        if (value == 0) {
            return 0;
        }

        if (value < 0) {
            return 9999999;
        }

        if (cache[value] == 0) {
            int q = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                int result = 1 + recursionMCC(coins, value - coins[i], cache, trace);
                if (result < q) {
                    q = result;
                    cache[value] = q;
                    trace[value] = coins[i];
                }
            }
        }

        return cache[value];
    }
}
