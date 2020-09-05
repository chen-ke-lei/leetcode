package oj.swordtooffer;

public class Problem17 {
    public int[] printNumbers(int n) {
        int maxnum = 1;
        for (int i = 0; i < n; i++)
            maxnum *= 10;
        int[] res = new int[maxnum - 1];
        for(int i=0;i<maxnum;i++)
            res[i]=i+1;
        return res;
    }
}
