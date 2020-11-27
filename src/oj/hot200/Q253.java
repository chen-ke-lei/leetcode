package oj.hot200;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q253 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        int res = 1;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            while (!queue.isEmpty() && queue.peek() <= intervals[i][0]) queue.poll();
            queue.offer(intervals[i][1]);
            res = res > queue.size() ? res : queue.size();
        }
        return res;
    }
}
