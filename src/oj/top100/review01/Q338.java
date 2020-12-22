package oj.top100.review01;

public class Q338 {
    public int[] countBits(int num) {
        if (num == 0) return new int[]{0};
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i / 2];
            if (i % 2 == 1) res[i]++;
        }
        return res;
    }
}
