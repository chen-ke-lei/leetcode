package oj.top100.review01;

public class Q72 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp.length; i++) dp[i][0] = i;
        for (int i = 0; i < dp[0].length; i++) dp[0][i] = i;
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                int tmp = word1.charAt(i) == word2.charAt(j) ? dp[i][j] : dp[i][j] + 1;
                dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1]+1, tmp), dp[i + 1][j]+1);
            }
        }
        return dp[dp.length - 1][dp[dp.length - 1].length - 1];
    }
}
