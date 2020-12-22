package oj.top100.review01;

import java.util.Stack;

public class Q155 {
    class MinStack {
        Stack<Integer> stackA, stackB;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stackA = new Stack<>();
            stackB = new Stack<>();
        }

        public void push(int x) {
            if (stackB.isEmpty() || stackB.peek() >= x) {
                stackB.push(x);
            }
            stackA.push(x);
        }

        public void pop() {
            if (!stackA.isEmpty()) {
                int x = stackA.pop();
                if (!stackB.isEmpty() && x == stackB.peek()) stackB.pop();
            }
        }

        public int top() {
            return stackA.peek();
        }

        public int getMin() {
            return stackB.peek();
        }
    }
}
