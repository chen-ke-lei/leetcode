package oj.hot100;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0)
            return 0;

        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum - k))
                res += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
