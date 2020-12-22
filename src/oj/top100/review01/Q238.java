package oj.top100.review01;

import java.util.Arrays;

public class Q238 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] *= sum;
            sum *= nums[i];
        }
        sum = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            res[i] *= sum;
            sum *= nums[i];
        }
        return res;
    }
}
