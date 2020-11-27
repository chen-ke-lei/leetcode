package oj.interview_tips;

public class Q16_05 {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            n /= 5;
            res += n;

        }
        return res;
    }
}
