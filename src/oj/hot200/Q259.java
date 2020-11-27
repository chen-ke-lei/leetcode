package oj.hot200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q259 {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) return 0;
        int res = 0;
        Arrays.sort(nums);
        Map<Integer, Integer> numNumber = new HashMap<>();
        for (int num : nums) {
            numNumber.put(num, numNumber.getOrDefault(num, 0) + 1);
        }
        int lastI = -1, lastJ = -1;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {

            }
        }
        return res;
    }
}
