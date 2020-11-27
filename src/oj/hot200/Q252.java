package oj.hot200;

import java.util.Arrays;

public class Q252 {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 1) return true;
        Arrays.sort(intervals, (x1, x2) -> {
            return x1[0] == x2[0] ? x1[1] - x2[1] : x1[0] - x2[0];
        });
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i + 1][0] < intervals[i][1]) return false;
        }
        return true;
    }
}
