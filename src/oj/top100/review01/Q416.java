package oj.top100.review01;

public class Q416 {
    public boolean canPartition(int[] nums) {
        if (nums.length <= 1) return false;
        int max = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            sum += nums[i];
        }
        if (sum % 2 == 1 || max * 2 > sum) return false;
        if (max * 2 == sum) return true;
        boolean[][] dp = new boolean[nums.length + 1][sum / 2 + 1];
        dp[0][0] = true;
        for (int i = 0; i < dp.length - 1; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (dp[i][j] == true) {
                    dp[i+1][j]=true;
                    if (nums[i] + j == sum / 2) return true;
                    if (nums[i] + j < sum / 2) {
                        dp[i + 1][nums[i] + j] = true;
                    }
                }
            }
        }
        return dp[nums.length][sum / 2];
    }


}
