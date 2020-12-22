package oj.top100.review01;

public class Q96 {
    public int numTrees(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                tmp += dp[j] * dp[i - j - 1];
            }
            dp[i] = tmp;
        }
        return dp[n];
    }
}
