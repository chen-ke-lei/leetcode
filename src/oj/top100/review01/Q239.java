package oj.top100.review01;

import java.util.Deque;
import java.util.LinkedList;

public class Q239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.getLast() < (i - k + 1)) deque.removeLast();
            while (!deque.isEmpty() && nums[deque.getFirst()] < nums[i]) deque.removeFirst();
            deque.addFirst(i);
            if (i >= k - 1) res[index++] = nums[deque.getLast()];

        }
        return res;
    }
}
