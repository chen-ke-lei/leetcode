package oj.top100.review01;

public class Q198 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(nums[0] + nums[2], nums[1]);
        int max = Math.max(nums[0] + nums[2], nums[1]);
        int a = nums[0], b = nums[1], c = nums[2] + a;
        for (int i = 3; i < nums.length; i++) {
            int tmp = nums[i] + Math.max(a, b);
            a = b;
            b = c;
            c = tmp;
            max = Math.max(max, c);
        }
        return max;
    }
}
