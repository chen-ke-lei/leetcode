package oj.hot200;

import java.util.HashMap;
import java.util.Map;

public class Q666 {
    public int pathSum(int[] nums) {
        Map<Integer, int[]> pre = new HashMap<>(), next = new HashMap<>();
        int nowD = 5;
        for (int i = nums.length - 1; i >= 0; i--) {
            int d = nums[i] / 100;
            int p = (nums[i] - d * 100) / 10;
            int v = nums[i] % 10;
            if (d != nowD) {
                nowD = d;
                pre = next;
                next = new HashMap<>();
            }
            int val = 0;
            int pow = 0;
            if (pre.containsKey(p * 2 - 1)) {
                val += pre.get(p * 2 - 1)[0];
                pow += pre.get(p * 2 - 1)[1];
            }
            if (pre.containsKey(p * 2)) {
                val += pre.get(p * 2)[0];
                pow += pre.get(p * 2)[1];
            }
            if (pow == 0) pow = 1;
            val += pow * v;
            next.put(p, new int[]{val, pow});
        }
        return next.get(1)[0];
    }
}
