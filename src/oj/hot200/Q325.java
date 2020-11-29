package oj.hot200;

import java.util.HashMap;
import java.util.Map;

public class Q325 {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        int sum = nums[0];
        map.put(sum, 0);
        if (sum == k) res = 1;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                res = res > i + 1 ? res : i + 1;
            }
            if (!map.containsKey(sum)) map.put(sum, i);
            if (map.containsKey(sum - k)) {
                res = res > i - map.get(sum - k) ? res : i - map.get(sum - k);
            }
        }
        return res;
    }
}
