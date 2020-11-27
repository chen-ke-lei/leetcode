package oj.hot200;

public class Q651 {
    public int maxA(int N) {
        if (N <= 6) return N;
        int tmp = 3;
        int max = 6;
        int sub = 6;
        for (int i = 7; i <= N; i++) {
            if (i % 3 != 0) {
                max += tmp;
            }
        }
        return max;
    }
}
