package oj.top100.review01;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q253 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length <= 1) return intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
        int max = 0;
        for (int[] interval : intervals) {
            while (!queue.isEmpty() && queue.peek() <= interval[0]) queue.poll();
            queue.offer(interval[1]);
            max = Math.max(max, queue.size());
        }

        return max;
    }
}
