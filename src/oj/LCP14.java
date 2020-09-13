package oj;

public class LCP14 {
    public int splitArray(int[] nums) {
        int res=nums.length;
        int left=0;
        return res;
    }

    int sign(int N,int M){
        int r = M % N;
        while(r > 0){
            M = N;
            N = r;
            r = M % N;
        }
        return N;
    }

}
