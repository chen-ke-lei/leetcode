package oj.hot100;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if (nums.length <= 1)
            return false;
        int sum = 0;
        for (int i : nums)
            sum += i;
        if (sum % 2 == 1)
            return false;
        sum /= 2;
        Arrays.sort(nums);
        int target = nums[0];
        int beg = 0;
        for (int i = 1; i < nums.length; i++) {
            target += nums[i];
            if (target == sum)
                return true;
            if (target > sum) {
                for (; beg < i && target > sum; beg++) {
                    target -= nums[beg];
                }
                if (target == sum)
                    return true;
            }
        }
        return false;
    }
}
