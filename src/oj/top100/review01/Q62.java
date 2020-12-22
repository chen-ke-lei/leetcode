package oj.top100.review01;

public class Q62 {
    public int uniquePaths(int m, int n) {
        long a = m - 1, b = n - 1;
        long x = a + b;
        long tmp = Math.min(a, b);
        long res = 1;
        for (int i = 0; i < tmp; i++) {
            res *= (x - i);
            res /= (i + 1);
        }
        return (int) res;
    }
}
