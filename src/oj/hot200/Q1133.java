package oj.hot200;

import java.util.HashMap;
import java.util.Map;

public class Q1133 {
    public int largestUniqueNumber(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int res = -1;
        for (Integer integer : map.keySet()) {
            if (map.get(integer) > 1) continue;
            res = res < integer ? integer : res;
        }
        return res;
    }
}
