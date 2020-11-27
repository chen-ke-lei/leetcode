package oj.interview_tips;

public class Q08_01 {
    public int waysToStep(int n) {
        if (n <= 2) return n;
        long a = 1, b = 1, c = 2;
        for (int i = 3; i <= n; i++) {
            long tmp = a + b + c;
            a = b;
            b = c;
            c = tmp%10000007;
        }
        return (int) c;
    }
}
