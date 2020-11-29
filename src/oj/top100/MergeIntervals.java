package oj.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int[] ints : intervals) {
            if (list.isEmpty()) list.add(ints);
            else {
                int[] tmp = list.get(list.size() - 1);
                if (tmp[0] == ints[0]) {
                    list.set(list.size()-1, ints);
                } else if (ints[0] > tmp[0] && ints[0] <= tmp[1]) {
                    tmp[1] = Math.max(ints[1], tmp[1]);
                } else {
                    list.add(ints);
                }
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
