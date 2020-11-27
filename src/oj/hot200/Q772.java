package oj.hot200;

import java.util.Stack;

public class Q772 {
    public int calculate(String s) {
        Stack<Character> sign = new Stack<>();
        Stack<Integer> num = new Stack<>();
        int number = -1;
        for (char c : s.toCharArray()) {
            if ((c < '0' || c > '9') && number != -1) {
                num.push(number);
                number = -1;
            }
            if (c == ' ') {
                continue;
            } else if (c >= '0' && c <= '9') {
                number = number == -1 ? 0 : number;
                number = number * 10 + c - '0';
            } else if (c == '(') {
                sign.push(c);
            } else if (c == ')') {
                while (sign.peek() != '(') {
                    int a = num.pop(), b = num.pop();
                    num.push(cal(a, b, sign.pop()));
                }
                sign.pop();
            } else if (c == '+' || c == '-') {
                while (!sign.isEmpty()&&sign.peek()!='(') {
                    num.push(cal(num.pop(), num.pop(), sign.pop()));
                }
                sign.push(c);
            } else {
                while (!sign.isEmpty() && (sign.peek() == '*' || sign.peek() == '/'))
                    num.push(cal(num.pop(), num.pop(), sign.pop()));
                sign.push(c);
            }
        }
        if (number != -1) {
            num.push(number);
        }
        while (!sign.isEmpty()) {
            num.push(cal(num.pop(), num.pop(), sign.pop()));
        }
        return num.pop();
    }

    int cal(int a, int b, char sign) {
        int tmp = 0;
        switch (sign) {
            case '+':
                tmp = a + b;
                break;
            case '-':
                tmp = b-a;
                break;
            case '*':
                tmp = a * b;
                break;
            case '/':
                tmp = b/a;
                break;
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(new Q772().calculate("10/2/5"));
    }
}
