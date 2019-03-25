import java.util.Arrays;

public class Stocks1 {

    public static void main(String[] args) {

        int[] numbers = {1, 3, 2, 8, 4, 9};

        stocks1(numbers);//one transaction
        //        stocks2(numbers);//unimited transactions
        //        System.out.println(stocks3(numbers));
        //        ;//two transactions
        //        stocks4(3, numbers);//k transactions
        //        stocks4StateMachineLogic(3, numbers); //k transactions with State logic
        //        System.out.println(stocks5(numbers));
        //        ;//cooldown
        //        stocks6(numbers, 2);//transaction fee
    }

    private static int stocks6(int[] prices, int fee) {
        if (prices.length < 2) {
            return 0;
        }

        int b0 = -prices[0];
        int b1 = b0;
        int s1 = 0;
        int s0 = 0;
        for (int i = 1; i < prices.length; i++) {
            b0 = Integer.max(b1, s1 - prices[i]);
            s0 = Integer.max(s1, b1 + prices[i] - fee);
            b1 = b0;
            s1 = s0;
        }

        return s0;
    }

    private static int stocks5(int[] prices) {

        if (prices.length < 2) {
            return 0;
        }

        int b0 = -prices[0], b1 = b0;
        int s0 = 0, s1 = 0, s2 = 0;

        //        for (int i = 1; i < prices.length; i++) {
        //            b0 = Integer.max(b1, s2 - prices[i]);
        //            s0 = Integer.max(s1, b1 + prices[i]);
        //            b1 = b0;
        //            s2 = s1;
        //            s1 = s0;
        //        }
        //        return s0;

        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        buy[1] = Integer.max(-prices[0], -prices[1]);
        sell[1] = Integer.max(sell[0], buy[0] + prices[1]);
        for (int i = 2; i < prices.length; i++) {
            buy[i] = Integer.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Integer.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[prices.length - 1];
    }

    private static int stocks4StateMachineLogic(int k, int[] prices) {

        if (prices.length < 2) {
            return 0;
        }

        if (k > prices.length / 2) {
            int maxProfit = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i + 1] > prices[i]) {
                    maxProfit = maxProfit + (prices[i + 1] - prices[i]);
                }
            }
            return maxProfit;
        }

        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);

        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                buy[i] = Integer.max(buy[i], sell[i - 1] - price);
                sell[i] = Integer.max(sell[i], buy[i] + price);
            }
        }
        return sell[k];
    }

    private static int stocks4(int k, int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        if (k > prices.length / 2) {
            int maxProfit = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i + 1] > prices[i]) {
                    maxProfit = maxProfit + (prices[i + 1] - prices[i]);
                }
            }
            return maxProfit;
        }

        int[][] dp = new int[k + 1][prices.length];

        for (int i = 1; i <= k; i++) {
            int profitAfterSelling = 0;
            int maxProfitSoFar = dp[i - 1][0] - prices[0];
            for (int days = 1; days < prices.length; days++) {
                maxProfitSoFar = Integer.max(maxProfitSoFar, dp[i - 1][days] - prices[days]);
                profitAfterSelling = prices[days] + maxProfitSoFar;
                dp[i][days] = Integer.max(profitAfterSelling, dp[i][days - 1]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[k][prices.length - 1];
    }

    private static int stocks3(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        if (prices.length < 6) {
            int maxProfit = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i + 1] > prices[i]) {
                    maxProfit = maxProfit + (prices[i + 1] - prices[i]);
                }
            }
            return maxProfit;
        }
        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;

        //        for (int i = 0; i < prices.length; i++) {
        //            buy1 = Integer.max(buy1, -prices[i]);
        //            sell1 = Integer.max(sell1, buy1 + prices[i]);
        //            buy2 = Integer.max(buy2, sell1 - prices[i]);
        //            sell2 = Integer.max(sell2, buy2 + prices[i]);
        //        }
        //        return buy1;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Integer.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Integer.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        System.out.println(Arrays.toString(sell));
        return sell[prices.length - 1];
    }

    private static void stocks2(int[] price) {

        int maxProfit = 0;
        for (int i = 0; i < price.length - 1; i++) {
            if (price[i] < price[i + 1]) {
                maxProfit = maxProfit + (price[i + 1] - price[i]);
            }
        }
        System.out.println(maxProfit);
    }

    private static void stocks1(int[] price) {

        int buy = Integer.MIN_VALUE;
        int sell = 0;
        for (int i = 0; i < price.length; i++) {
            buy = Integer.max(buy, -price[i]);
            sell = Integer.max(sell, buy + price[i]);
        }
        System.out.println(sell);

        int minBuy = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < price.length; i++) {
            minBuy = Integer.min(minBuy, price[i]);
            maxProfit = Integer.max(maxProfit, price[i] - minBuy);
        }
        System.out.println(maxProfit);
    }
}
