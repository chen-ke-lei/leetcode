package oj.hot100;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int len = 1;
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[len]) {
                dp[++len] = nums[i];
            } else {
                if (dp[1] > nums[i]) {
                    dp[1] = nums[i];
                } else {
                    int left = 1, right = len;

                    while (left < right) {
                        int tmp = (left + right) / 2;
                        if (dp[tmp] == nums[i]) {
                            break;
                        }
                        if (dp[tmp] > nums[i]) {
                            right = tmp;
                        } else if (dp[tmp] < nums[i]) {
                            if (tmp == left) {
                                dp[tmp+1] = nums[i];
                                break;
                            } else {
                                left = tmp;
                            }
                        }
                    }
                }

            }
        }

        return len;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,5,6,2,5,4,19,5,6,7,12};
        new LongestIncreasingSubsequence().lengthOfLIS(nums);
    }
}
