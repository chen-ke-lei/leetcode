package oj.hot100;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int res = 0;
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {

        }

        return res;
    }
}
