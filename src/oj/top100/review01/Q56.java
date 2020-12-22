package oj.top100.review01;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (res.isEmpty()) res.add(interval);
            else {
                if (interval[0] <= res.get(res.size() - 1)[1]) {
                    res.get(res.size() - 1)[1] = Math.max(interval[1], res.get(res.size() - 1)[1]);
                }else
                    res.add(interval);

            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
