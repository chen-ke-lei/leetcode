package oj.top100.review01;

public class Q136 {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++)
            res ^= nums[i];
        return res;
    }
}