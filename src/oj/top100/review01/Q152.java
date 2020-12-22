package oj.top100.review01;

public class Q152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max = nums[0];
        int[][] dp = new int[nums.length + 1][2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = Math.max(0, max);
                dp[i + 1][0] = 0;
                dp[i + 1][1] = 0;
            } else if (nums[i] > 0) {
                if (dp[i][0] != 0) {
                    dp[i + 1][0] = dp[i][0] * nums[i];
                } else {
                    dp[i + 1][0] = nums[i];
                }
                dp[i + 1][1] = dp[i][1] * nums[i];
                max = Math.max(max, dp[i + 1][0]);
            } else {
                if (dp[i][1] != 0) {
                    dp[i + 1][0] = dp[i][1] * nums[i];
                    max = Math.max(dp[i + 1][0], max);
                } else {
                    max = Math.max(max, nums[i]);
                    dp[i + 1][0] = 0;
                }
                dp[i + 1][1] = dp[i][0] * nums[i];
            }
        }
        return max;
    }
}
