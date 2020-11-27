package oj.hot200;

import java.util.Arrays;

public class Q1100 {
    public int numKLenSubstrNoRepeats(String S, int K) {
        if (S.length() < K) return 0;
        if(K==1)return S.length();
        int res = 0;
        int start = 0;
        int[] index = new int[26];
        Arrays.fill(index, -1);
        index[S.charAt(0) - 'a'] = 0;
        for (int i = 1; i < S.length(); i++) {
            if (index[S.charAt(i) - 'a'] < start) {
                if (i - start + 1 == K) {
                    res++;
                    start++;
                }
            } else {
                start=index[S.charAt(i) - 'a']+1;
            }
            index[S.charAt(i) - 'a'] = i;
        }
        if (S.length() - start == K) res++;
        return res;
    }
}
