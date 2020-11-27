package oj.hot200;

import java.util.Arrays;

public class Q1196 {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int last = 5000;
        int res = 0;
        for (int i : arr) {
            if (last >= i) {
                last -= i;
                res++;
            } else
                break;
        }
        return res;
    }
}
