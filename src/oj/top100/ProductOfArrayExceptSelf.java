package oj.top100;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length <= 1)
            return nums;
        int[] rs = new int[nums.length];
        rs[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            rs[i] = rs[i - 1] * nums[i - 1];
        }
        int tmp = 1;
        for (int i = nums.length - 1; i >= 0; i++) {
            rs[i] *= tmp;
            tmp *= nums[i];
        }

        return rs;
    }
}
