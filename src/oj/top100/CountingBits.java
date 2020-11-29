package oj.top100;

public class CountingBits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        if (num == 0)
            return res;
        res[1] = 1;
        for (int i = 2; i <= num; i++) {
            if (i % 2 == 0) res[i] = res[i / 2];
            else res[i] = res[i / 2] + 1;
        }
        return res;
    }
}
