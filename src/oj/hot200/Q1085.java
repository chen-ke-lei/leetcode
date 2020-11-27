package oj.hot200;

public class Q1085 {
    public int sumOfDigits(int[] A) {
        if (A.length == 0) return 0;
        int min = A[0];
        for (int i = 1; i < A.length; i++) {
            min = min < A[i] ? min : A[i];
        }
        int res = 0;
        while (min > 0) {
            res += min % 10;
            min /= 10;
        }

        return (res + 1) % 2;
    }
}
