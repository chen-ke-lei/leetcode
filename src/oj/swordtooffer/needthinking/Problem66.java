package oj.swordtooffer.needthinking;

public class Problem66 {
    public int[] constructArr(int[] a) {
        if (a == null || a.length <= 2)
            return a;
        int[] res = new int[a.length];
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        left[0] = a[0];
        right[a.length - 1] = a[a.length - 1];
        for (int i = 1; i < a.length; i++) {
            left[i] = left[i - 1] * a[i];
            right[a.length - 1 - i] = a[a.length - 1 - i] * right[a.length - i];
        }
        for (int i = 1; i < a.length - 1; i++) {
            res[i] = left[i - 1] * right[i + 1];
        }
        res[0] = right[1];
        res[a.length - 1] = left[a.length - 2];
        return res;
    }
}
