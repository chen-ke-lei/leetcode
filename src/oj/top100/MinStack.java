package oj.top100;



import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
         stack=new Stack<>();
        minStack=new Stack<>();

    }

    public void push(int x) {
        stack.push(x);
       if(minStack.isEmpty()||minStack.peek()>=x)
           minStack.push(x);
    }

    public void pop() {
        int i=stack.pop();

        if(i==minStack.peek()) minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {

        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack=new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        stack.getMin();
        stack.pop();
        stack.top();
        stack.getMin();
    }
}
