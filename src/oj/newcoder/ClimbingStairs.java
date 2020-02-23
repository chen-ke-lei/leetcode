package oj.newcoder;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        int pre = 1, next = 2, res = 0;
        for (int i = 3; i <= n; i++) {
            res = next + pre;
            pre = next;
            next = res;
        }
        return res;
    }
}
