package oj.interview_tips;

import java.util.Stack;

public class Q03_05 {
    class SortedStack {
        Stack<Integer> esc = new Stack<>(), desc = new Stack<>();

        public SortedStack() {

        }

        public void push(int val) {
            if (isEmpty()) esc.push(val);
            if (!esc.isEmpty() && esc.peek() >= val) esc.push(val);
            if (!desc.isEmpty() && desc.peek() <= val) desc.push(val);
        }

        public void pop() {
            if (isEmpty()) return;
            if (esc.isEmpty()) {
                while (!desc.isEmpty())
                    esc.push(desc.pop());
            }
            esc.pop();
        }

        public int peek() {
            if (isEmpty()) return -1;
            if (esc.isEmpty()) {
                while (!desc.isEmpty())
                    esc.push(desc.pop());
            }
            return esc.peek();
        }

        public boolean isEmpty() {
            return esc.isEmpty() && desc.isEmpty();
        }
    }
}
