package oj.top100.review01;

public class Q70 {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int pre = 1, next = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = next;
            next += pre;
            pre = tmp;
        }
        return next;
    }
}
