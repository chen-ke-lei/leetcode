package oj.interview_tips;

import java.util.Arrays;

public class Q08_11 {

    public int waysToChange(int n) {
        int[] coins = new int[]{1, 5, 10, 25};
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i < n + 1; i++) {
                if (i - coin >= 0) dp[i] += dp[i - coin];
            }
        }
//        System.out.println(Arrays.toString(dp));
        return (int) (dp[n] % 1000000007);

    }

    public static void main(String[] args) {
        System.out.println(new Q08_11().waysToChange(10));
    }

}
