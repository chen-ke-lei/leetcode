package oj.top100;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];
        int res = heights[0];
        Stack<Integer> stack = new Stack<>();
        stack.add(heights[0]);
        for (int i = 1; i < heights.length; i++) {
            int num = heights[i];
            res = res > num ? res : num;
            int stackNum = stack.peek();
            if(stackNum<num){

            }
        }
        return res;
    }
}
