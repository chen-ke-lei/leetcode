package oj.swordtooffer.needthinking;

import java.util.HashSet;
import java.util.Set;

public class Problem57 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Set<Integer> map = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.contains(nums[i]) && nums[i] * 2 == target) {
                res[0] = nums[i];
                res[1] = nums[i];
                return res;
            }
            map.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (target - nums[i] == nums[i])
                continue;
            if (map.contains(target - nums[i])) {
                res[0] = nums[i];
                res[1] = target - nums[i];
                return res;
            }
        }
        return res;
    }
}
