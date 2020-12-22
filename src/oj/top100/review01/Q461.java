package oj.top100.review01;

public class Q461 {
    public int hammingDistance(int x, int y) {
        int res = 0;
        x ^= y;
        while (x > 0) {
            if (x % 2 == 1) res++;
            x /= 2;
        }
        return res;
    }
}
