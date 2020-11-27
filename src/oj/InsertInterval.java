package oj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> tmp = new ArrayList<>();
        for (int[] ints : intervals)
            tmp.add(ints);
        tmp.add(newInterval);
        tmp.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        res.add(tmp.get(0));
        for (int i = 1; i < tmp.size(); i++) {
            int[] pre = res.get(res.size() - 1);
            int[] ori = tmp.get(i);
            if (ori[0] <= pre[1]) {
                pre[1] = Math.max(pre[1], ori[1]);
            } else {
                res.add(ori);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
