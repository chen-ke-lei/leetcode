package oj.hot200;

public class Q634 {
    public int findDerangement(int n) {
        if (n <= 1) return 0;
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]);
            if (dp[i] > 1000000007) dp[i] %= 1000000007;
        }
        return dp[n];
    }
}
