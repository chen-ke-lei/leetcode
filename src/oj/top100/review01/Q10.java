package oj.top100.review01;

public class Q10 {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) return true;

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < p.length(); i++) {
            boolean star = false;
            char c = p.charAt(i);
            if (i < p.length() - 1 && p.charAt(i + 1) == '*') {
                i++;
                star = true;
            }
            for (int j = dp.length - 1; j >= 0; j--) {
                if (dp[j] == true) {
                    if (star) {
                        for (int k = j + 1; k < dp.length; k++) {
                            if (dp[k]) break;
                            if (c == '.') dp[k] = true;
                            else if (c == s.charAt(k - 1)) dp[k] = true;
                            else break;

                        }
                    } else {
                        dp[j] = false;
                        if (j < dp.length - 1) {
                            if (c == '.' || c == s.charAt(j)) dp[j + 1] = true;
                        }
                    }
                }
            }
        }
        return dp[dp.length - 1];
    }
}
