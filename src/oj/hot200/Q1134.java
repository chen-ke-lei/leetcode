package oj.hot200;

public class Q1134 {
    public boolean isArmstrong(int N) {
        int len = (N + "").length();
        int res = 0;
        int num = N;
        while (num > 0) {
            res += Math.pow( num % 10,len);
            num /= 10;
        }
        return res == N;
    }
}
