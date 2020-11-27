package oj.interview_tips;

import java.util.Arrays;

public class Q16_06 {
    public int smallestDifference(int[] a, int[] b) {
        long[] tmp = new long[a.length + b.length];
        for (int i = 0; i < tmp.length; i++) {
            if (i < a.length) tmp[i] = Math.abs(a[i]);
            else tmp[i] = Math.abs(b[i - a.length]);
        }
        Arrays.sort(tmp);
        long res = Integer.MAX_VALUE;
        for (int i = 0; i < tmp.length - 1; i++) {
            res = res > tmp[i + 1] - tmp[i] ? res : tmp[i + 1] - tmp[i];
            if (res == 0) return 0;
        }
        return (int) res;
    }
}
