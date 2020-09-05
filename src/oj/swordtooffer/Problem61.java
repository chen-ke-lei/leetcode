package oj.swordtooffer;

import java.util.Arrays;

public class Problem61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroNum = 0;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zeroNum++;
            else if (pre == 0)
                pre = nums[i];
            else if (pre + 1 == nums[i])
                pre++;
            else if (pre + zeroNum + 1 >= nums[i]) {
                zeroNum -= (nums[i] - pre + 1);
                pre = nums[i];

            } else
                return false;
        }
        return true;
    }
}
