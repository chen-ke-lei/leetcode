package oj.newcoder;

public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int res = 0, tmp = 0, maxMinus = 0;
        boolean minus = true;
        for (int i = 0; i < A.length; i++) {
            tmp = A[i] += tmp;
            res = res > tmp ? res : tmp;
            if (tmp < 0) {
                if (maxMinus >= 0)
                    maxMinus = A[i];
                maxMinus = maxMinus > A[i] ? maxMinus : A[i];
                tmp = 0;
            }
            if (A[i] >= 0)
                minus = false;
        }
        if (minus)
            return maxMinus;
        return res;
    }
}
