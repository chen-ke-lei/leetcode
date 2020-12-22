package oj.top100.review01;

public class Q32 {
    public int longestValidParentheses(String s) {
        if (s.length() <= 1) return 0;
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (i > 0 && s.charAt(i - 1) == ')') {
                    dp[i] = dp[i - 1];
                }
            } else if (c == ')') {
                if (i > 0) {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = dp[i - 1] + 2;
                    } else {
                        if (dp[i - 1] > 0&&i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                            dp[i] = dp[i - 1] + 2;
                            dp[i] += dp[i - 1 - dp[i - 1]];

                        }
                    }
                }
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Q32().longestValidParentheses("(()())"));
    }
}
