package oj.top100;

public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        if (n <= 1)
            return n;
        int[] step = new int[n + 1];
        step[0] = 1;
        step[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sub = 0;
            for (int j = 1; j <= i; j++) {
                sub += (step[j - 1] * step[i - j]);
            }
            step[i] = sub;
        }
        return step[n];
    }
}
