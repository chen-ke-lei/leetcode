package oj.swordtooffer;

public class Problem14II {
    public int cuttingRope(int n) {
        if (n <= 3)
            return n;
        int res = 1;
        int last = n % 2 + 2;
        int times = n / 2;
        for (int i = 1; i < times; i++)
            res <<= 1;

        return res * last;
    }
}
