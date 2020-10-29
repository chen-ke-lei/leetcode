package oj.hot100;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] a = new int[nums.length + 1];
        int[] b = new int[nums.length + 1];
        int res = nums[0];
//        a[0] = 1;
//        b[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                a[i + 1] = a[i] == 0 ? nums[i] : a[i] * nums[i];
                b[i + 1] = b[i] == 0 ? 0 : b[i] * nums[i];
            } else if (nums[i] < 0) {
                a[i + 1] = b[i] == 0 ? 0 : nums[i] * b[i];
                b[i + 1] = a[i] == 0 ? nums[i] : a[i] * nums[i];
            } else {
                a[i + 1] = 0;
                b[i + 1] = 0;
            }
            res = res > a[i + 1] ? res : a[i + 1];
        }
        return res;
    }
}
