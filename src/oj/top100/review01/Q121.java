package oj.top100.review01;

public class Q121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int res = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                res = Math.max(res, prices[i] - min);
            } else if (prices[i] < min) min = prices[i];
        }
        return res;
    }
}
