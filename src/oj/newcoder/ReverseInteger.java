package oj.newcoder;

public class ReverseInteger {
    public int reverse(int x) {
        long a = Long.valueOf(x);
        if (a < 0)
            a = -a;
        long b = 0;
        while (a > 0) {
            b = (b * 10) + a % 10;
            a /= 10;
        }
        if(x<0)b=-b;
        return b > Integer.MAX_VALUE || b < Integer.MIN_VALUE ? 0 : (int) b;
    }
}
