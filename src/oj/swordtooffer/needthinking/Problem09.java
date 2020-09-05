package oj.swordtooffer.needthinking;

import java.util.Stack;

public class Problem09 {
}

class CQueue {
    Stack<Integer> first, next;

    public CQueue() {
        first = new Stack<>();
    }

    public void appendTail(int value) {
        first.push(value);
    }

    public int deleteHead() {
        int res = -1;
        next = new Stack<>();
        while (!first.isEmpty()) {
            res = first.pop();
            next.push(res);
        }
        first = new Stack<>();
        while (next.isEmpty()) {
            first.push(next.pop());
        }
        return res;
    }
}