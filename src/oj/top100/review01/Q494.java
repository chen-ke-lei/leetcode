package oj.top100.review01;

import java.util.HashMap;
import java.util.Map;

public class Q494 {
    public int findTargetSumWays(int[] nums, int S) {
        Map<Integer, Integer> pre = new HashMap<>(), next = new HashMap<>();
        pre.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            for (Integer integer : pre.keySet()) {
                next.put(integer + nums[i], next.getOrDefault(integer + nums[i], 0) + pre.get(integer));
                next.put(integer - nums[i], next.getOrDefault(integer - nums[i], 0) + pre.get(integer));
            }
            pre = next;
            next = new HashMap<>();
        }
        return pre.getOrDefault(S, 0);
    }

}
