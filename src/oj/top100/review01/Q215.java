package oj.top100.review01;

import java.util.PriorityQueue;

public class Q215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) queue.poll();
        }
        int res = queue.poll();
        while (!queue.isEmpty()) res = queue.poll();
        return res;

    }
}
