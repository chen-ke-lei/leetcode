package oj.hot200;

import java.util.Deque;
import java.util.LinkedList;

public class Q1063 {
    public int validSubarrays(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int res = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
       //     while (!deque.isEmpty() && nums[i] < nums[deque.getLast()]) res += (i - deque.removeLast());
            while (!deque.isEmpty() && nums[i] < nums[deque.getFirst()]) res += (i - deque.removeFirst());
            deque.addFirst(i);
        }
        int max = nums.length - 1;
        while (!deque.isEmpty()) res += (max - deque.removeLast() + 1);
        return res;
    }
}
