package oj.newcoder;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            int a,b;
            switch (tokens[i]) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                     a=stack.pop();
                     b=stack.pop();
                    stack.push(b-a);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                     a=stack.pop();
                     b=stack.pop();
                    stack.push(b/a);
                    break;
                default:
                    stack.push(Integer.valueOf(tokens[i]));
                    break;
            }
        }
        return stack.pop();
    }
}
