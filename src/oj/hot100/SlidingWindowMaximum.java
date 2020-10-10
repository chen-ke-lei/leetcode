package oj.hot100;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> index = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            while (!index.isEmpty()&&index.getFirst()+k<=i)
                index.removeFirst();
            while (!index.isEmpty()&&nums[index.getLast()]<nums[i])
                index.removeLast();
            index.addLast(i);
            if(i+1>=k)
                res[i-k+1]=nums[index.getFirst()];
        }
        return res;
    }
}
