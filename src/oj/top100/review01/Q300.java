package oj.top100.review01;

import java.util.Arrays;

public class Q300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length];
        int max = 0;
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int num : nums) {
            if (dp[0] >= num) {
                dp[0] = num;
            } else if (dp[max] < num) {
                max++;
                dp[max] = num;
            }else if (dp[max]==num){
                continue;
            } else {
                int left = 0, right = max;
                while (left < right) {
                    int tmp = (left + right) / 2;
                    if (dp[tmp] < num) {
                        left = tmp;
                    } else if (dp[tmp] == num)
                        break;
                    else {
                        right = tmp;
                    }
                    if (left + 1 == right) {
                        dp[right] = num;
                        break;
                    }
                }
            }
        }
        return max + 1;
    }
}
