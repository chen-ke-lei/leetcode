package oj.hot200;

import java.util.Arrays;

public class Q1099 {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length-1, res = -1;
        while (left < right) {
            if (nums[left] + nums[right] >= k) right--;
            else {
                if (res == -1) {
                    res = nums[left] + nums[right];
                } else {
                    res = res > nums[left] + nums[right] ? res : nums[left] + nums[right];
                    left++;
                }
            }
        }
        return res;
    }
}
