package oj.hot100;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n<=2)
            return n;
        int pre=1,now=2;
        for(int i=3;i<=n;i++){
            int tmp=now;
            now+=pre;
            pre=tmp;
        }
        return now;
    }
}
