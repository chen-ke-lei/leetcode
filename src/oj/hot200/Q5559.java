package oj.hot200;

public class Q5559 {
    public int minimumMountainRemovals(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = i ;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = dp[i] < dp[j] + (i - j-1) ? dp[i] : dp[j] + (i - j - 1);
                }
            }
        }
        int[] dp2 = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            dp2[i] = nums.length - 1 - i;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    dp2[i] = dp2[i] < dp2[j] + (j - i - 1) ? dp2[i] : dp2[j] + (j - i - 1);
                }
            }
        }
        int res = nums.length;
        for (int i = 1; i < nums.length - 1; i++) {
            res = res < dp[i] + dp2[i] ? res : dp[i] + dp2[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q5559().minimumMountainRemovals(new int[]{2,1,1,5,6,2,3,1}));
    }
}
