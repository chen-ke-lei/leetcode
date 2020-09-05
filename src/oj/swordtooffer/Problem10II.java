package oj.swordtooffer;

public class Problem10II {
    public int numWays(int n) {
        if (n <= 1)
            return n;
        long pre = 0, res = 1, tmp = 0;
        for (int i = 2; i <= n; i++) {
            tmp = res;
            res += pre;
            if(res>1000000007) res%=1000000007;
            pre = tmp;
        }
        return (int) res % 1000000007;

    }
}
