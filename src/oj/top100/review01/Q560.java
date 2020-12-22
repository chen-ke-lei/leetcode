package oj.top100.review01;

import java.util.HashMap;
import java.util.Map;

public class Q560 {
    public int subarraySum(int[] nums, int k) {
        int max = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            if (map.containsKey(sum - k)) {
                max += map.get(sum - k);
            }
        }
        return k==0?max-nums.length:max;
    }
}
