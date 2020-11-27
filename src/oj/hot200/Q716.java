package oj.hot200;

import java.util.Stack;

public class Q716 {
    class MaxStack {
        Stack<Integer> stack = new Stack<>(), stackMax = new Stack<>();

        /**
         * initialize your data structure here.
         */
        public MaxStack() {

        }

        public void push(int x) {
            stack.push(x);
            if (stackMax.isEmpty() || stackMax.peek() <= x) stackMax.push(x);
        }

        public int pop() {
            return 0;
        }

        public int top() {
            return 0;
        }

        public int peekMax() {
            return 0;
        }

        public int popMax() {
            return 0;
        }
    }
}
