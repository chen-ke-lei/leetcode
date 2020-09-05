package oj.swordtooffer;

public class Problem63 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (min > prices[i])
                min = prices[i];
            else
                res = prices[i] - min > res ? prices[i] - min : res;
        }
        return res;
    }
}
