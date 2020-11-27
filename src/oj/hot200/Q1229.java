package oj.hot200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1229 {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List res = new ArrayList();
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
        int i = 0, j = 0;
        while (i < slots1.length && j < slots2.length) {
            int start = Math.max(slots1[i][0], slots2[j][0]);
            int end = Math.min(slots1[i][1], slots2[j][1]);
            if (end - start >= duration) {
                res.add(start);
                res.add(start + duration);
                break;
            } else {
                if (end == slots1[i][1]) i++;
                else j++;
            }
        }
        return res;
    }
}
