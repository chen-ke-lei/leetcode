package oj.top100.review01;

public class Q221 {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') continue;
                int x = Integer.MAX_VALUE;
                if (i > 0) x = Math.min(x, dp[i - 1][j]);
                if (j > 0) x = Math.min(x, dp[i][j - 1]);
                if (i > 0 && j > 0) x = Math.min(x, dp[i - 1][j - 1]);
                if (i == 0 || j == 0) x = 0;
                dp[i][j] = (x + 1);
                max = Math.max(max, dp[i][j] * dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] arr = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(new Q221().maximalSquare(arr));
    }
}
