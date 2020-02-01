package oj.newcoder;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1)
            return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push('(');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{')
                        return false;
                    break;
                default:
                    return false;
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
}
