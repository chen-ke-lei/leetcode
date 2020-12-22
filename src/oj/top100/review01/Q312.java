package oj.top100.review01;

import java.util.Arrays;

public class Q312 {
    public int maxCoins(int[] nums) {
        if(nums.length==0)return 0;
        int[] tmp = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            tmp[i + 1] = nums[i];
        }
        tmp[0] = tmp[nums.length + 1] = 1;
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        dp[0][0] = dp[nums.length + 1][nums.length + 1] = 0;
        dfs(0, nums.length + 1, dp, tmp);
        return dp[0][nums.length + 1];
    }

    int dfs(int i, int j, int[][] dp, int[] nums) {
        if (i >= j - 1) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int max = 0;
        for (int k = i + 1; k < j; k++) {
            int val = nums[i] * nums[j] * nums[k];
            val = val + dfs(i, k, dp, nums) + dfs(k, j, dp, nums);
            max = Math.max(val, max);
        }
        dp[i][j] = max;
        return max;
    }
}
