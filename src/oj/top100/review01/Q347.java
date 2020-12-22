package oj.top100.review01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> tmp = new ArrayList<>(map.entrySet());
        tmp.sort((a, b) -> b.getValue() - a.getValue());
        for (int i = 0; i < k; i++) {
            res[i] = tmp.get(i).getKey();
        }
        return res;
    }
}
