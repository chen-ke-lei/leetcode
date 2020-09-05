package oj.swordtooffer;

public class Problem16 {
    public double myPow(double x, int n) {
        if (x == 0)
            return 0;
        if (n == 0)
            return 1;
        boolean minus = false;
        if (n < 0) {
            minus = true;
            n = -n;
        }
        double res = x;

        for (int i = 0; i < n; i++) {
            res *= x;
        }
        return minus ? (1 / res) : res;
    }
}
