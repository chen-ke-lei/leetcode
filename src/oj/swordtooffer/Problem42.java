package oj.swordtooffer;

public class Problem42 {
    public int maxSubArray(int[] nums) {
        int res = nums[0], tmp = res;
        for (int i = 1; i < nums.length; i++) {
            if (tmp < 0)
                tmp = 0;
            tmp += nums[i];
            res = tmp > res ? tmp : res;
        }
        return res;
    }
}
