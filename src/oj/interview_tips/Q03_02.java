package oj.interview_tips;

import java.util.ArrayList;
import java.util.List;

public class Q03_02 {
    static class MinStack {
        List<Integer> stack = new ArrayList<>(), minStack = new ArrayList<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            stack.add(x);
            if (minStack.isEmpty() || minStack.get(minStack.size() - 1) >= x) {
                minStack.add(x);
            }
        }

        public void pop() {
            if (stack.size() > 0) {
                if (stack.get(stack.size() - 1) .equals( minStack.get(minStack.size() - 1))) {
                    minStack.remove(minStack.size() - 1);
                }
                stack.remove(stack.size() - 1);
            }
        }

        public int top() {
            if (stack.size() > 0) return stack.get(stack.size() - 1);
            return 0;
        }

        public int getMin() {
            if (minStack.size() > 0) return minStack.get(minStack.size() - 1);
            return 0;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }

}
