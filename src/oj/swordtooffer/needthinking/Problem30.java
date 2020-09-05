package oj.swordtooffer.needthinking;

import java.util.ArrayList;

public class Problem30 {
}

class MinStack {
    ArrayList<Integer> ag = new ArrayList<>();
    int minNum = Integer.MIN_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        ag.add(x);
    }

    public void pop() {
        ag.remove(ag.size() - 1);
    }

    public int top() {
        return ag.get(ag.size() - 1);
    }

    public int min() {
        return 0;
    }
}