package oj.hot100;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : nums)
            queue.offer(i);
        for (int i = 0; i < k - 1; i++)
            queue.poll();
        return queue.poll();
    }

    public static void main(String[] args) {
        new KthLargestElementInAnArray().findKthLargest(new int[]{2, 1}, 1);
    }
}
