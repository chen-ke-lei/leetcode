package oj.interview_tips;

import java.util.Stack;

public class Q03_04 {
    class MyQueue {
        Stack<Integer> a = new Stack<>(), b = new Stack<>();

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {

        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            a.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (b.isEmpty()) {
                while (!a.isEmpty()) {
                    b.push(a.pop());
                }
            }
            if (!b.isEmpty()) {
                return b.pop();
            }
            return -1;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (b.isEmpty()) {
                while (!a.isEmpty()) {
                    b.push(a.pop());
                }
            }
            if (!b.isEmpty()) {
                return b.peek();
            }
            return -1;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return a.isEmpty() && b.isEmpty();
        }
    }
}
