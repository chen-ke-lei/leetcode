package oj.hot200;

public class Q484 {
    public int[] findPermutation(String s) {
        int[] res = new int[s.length() + 1];
        res[0] = 1;
        int max = 1, min = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'D') res[i] = --min;
            else res[i] = ++max;
        }
        if (min < 1) {
            int sub = 1 - min;
            for (int i = 0; i < res.length; i++) {
                res[i] += sub;
            }
        }
        return res;
    }
}
