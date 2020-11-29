package oj.top100;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int res=0;
        x^=y;
        while (x>0){
            res+=(x&1);
            x/=2;
        }
        return res;
    }
}
