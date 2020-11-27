package oj.hot200;

public class Q1259 {
    public int numberOfWays(int num_people) {
        if (num_people <= 4) return num_people / 2;
        long[] dp = new long[num_people / 2 + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < num_people / 2 + 1; i++) {
            dp[i] = 2;
            if ((i - 1) % 2 == 0) {
                dp[i] += dp[(i - 1) / 2] * dp[(i - 1) / 2] * i;
            } else
                dp[i] += dp[(i - 1) / 2] * dp[i / 2] * i;
            dp[i] %= 1000000007;
        }
        return (int) dp[dp.length - 1];
    }
}
