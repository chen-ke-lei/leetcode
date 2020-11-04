package oj;

public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        if (A[1] <= A[0]) return false;
        boolean res = false;
        for (int i = 2; i < A.length; i++) {
            if (A[i] == A[i - 1]) return false;
            if (A[i] > A[i - 1] && res) return false;
            if (A[i] < A[i - 1]) res = true;
        }
        return res;
    }
}
