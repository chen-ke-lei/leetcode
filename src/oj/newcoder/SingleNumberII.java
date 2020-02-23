package oj.newcoder;

public class SingleNumberII {
    public int singleNumber(int[] A) {
        if (A == null)
            return 0;
        byte[] bits = new byte[32];
        for (int i = 0; i < A.length; i++) {
            int tmp = A[i];
            for (int j = 0; j < 32 && tmp != 0; j++) {
                if (tmp % 2 == 1)
                    bits[j]++;
                if (bits[j] == 3)
                    bits[j] = 0;
                tmp >>>=1;
            }
        }
        int res = 0;
        for (int i = 31; i >=0; i--) {
            res *= 2;
            if (bits[i] == 1)
                res += 1;
        }
        return res;
    }
}
