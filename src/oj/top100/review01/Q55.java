package oj.top100.review01;

public class Q55 {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (!dp[i]) continue;
            for (int j = i + 1; j < Math.min(i + nums[i] + 1, nums.length); j++) {
                dp[j] = true;
            }
            if (dp[dp.length - 1]) return true;
        }

        return false;
    }
}
