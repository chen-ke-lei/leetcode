package oj.top100.review01;

import java.util.Stack;

public class Q739 {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        stack.push(res.length - 1);
        for (int i = T.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) stack.pop();
            if (!stack.isEmpty()) res[i] = stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}
