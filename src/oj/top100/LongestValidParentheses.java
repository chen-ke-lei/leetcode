package oj.top100;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s.length() <= 1) return 0;
        int res = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2;
                    if (i - 2 >= 0)
                        dp[i] += dp[i - 2];
                } else {
                    if (dp[i - 1] > 0) {
                        if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                            dp[i] = 2 + dp[i - 1];
                            if (i - 1 - dp[i - 1] - 1 >= 0)
                                dp[i] += dp[i - 1 - dp[i - 1] - 1];
                        }
                    }
                }
            }
            res = res > dp[i] ? res : dp[i];
        }
        return res;
    }
}
