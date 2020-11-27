package oj.interview_tips;

import java.util.ArrayList;
import java.util.List;

public class Q03_03 {
    class StackOfPlates {
        int stackLenth;
        List<List<Integer>> stacks;

        public StackOfPlates(int cap) {
            stackLenth = cap;
            stacks = new ArrayList<>();
        }

        public void push(int val) {
            if (stackLenth <= 0) return;
            if (stacks.isEmpty() || stacks.get(stacks.size() - 1).size() == stackLenth) {
                stacks.add(new ArrayList<>());
            }
            stacks.get(stacks.size() - 1).add(val);
        }

        public int pop() {
            return popAt(stacks.size() - 1);
        }

        public int popAt(int index) {
            if (stacks.size() <= index) return -1;
            List<Integer> stack = stacks.get(index);
            int val = stack.remove(stack.size() - 1);
            if (stack.isEmpty()) stacks.remove(index);
            return val;

        }
    }

    public static void main(String[] args) {
        Q03_03 q03_03 = new Q03_03();
        StackOfPlates stackOfPlates = q03_03.new StackOfPlates(1);
        stackOfPlates.push(1);
        stackOfPlates.push(2);
        stackOfPlates.popAt(1);
        stackOfPlates.pop();
        stackOfPlates.pop();

    }

}
