package oj.hot100;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int prePre = nums[0], pre = nums[1], now = nums[2] + nums[0];
        int res = Math.max(pre, now);
        for (int i = 3; i < nums.length; i++) {
            int tmp = Math.max(prePre, pre);
            tmp += nums[i];
            res = res > tmp ? res : tmp;
            prePre = pre;
            pre = now;
            now = tmp;
        }

        return res;
    }
}
