package oj.swordtooffer.needthinking;

import java.util.Stack;

public class Problem65 {
    public static void main(String[] av) {
        System.out.println(new Problem65().add(1, 2));
    }

    public int add(int a, int b) {
        int res = 0, bit = 0, abit = 0, bbit = 0;
        Stack<Integer> stack = new Stack<>();
        while (a != 0 || b != 0) {
            abit = a & 1;
            bbit = b & 1;
            if ((abit & bbit & bit) == 1) stack.push(1);
            else if ((abit ^ bbit ^ bit) == 1) {
                stack.push(1);
                bit = 0;
            } else if ((abit | bbit | bit) == 0)
                stack.push(0);
            else {
                stack.push(0);
                bit = 1;

            }
            a >>>= 1;
            b >>>= 1;
        }
        if (bit == 1)
            stack.push(1);
        while (!stack.isEmpty()) {
            res <<= 1;
            res += stack.pop();
        }
        return res;
    }
}
