package oj.newcoder;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n <= 2)
            return n;
        int[] tmp = new int[n + 1];
        tmp[0] = 1;
        tmp[1] = 1;
        tmp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int res = 0;
            for (int j = 0; j < i; j++) {
                res += (tmp[j] * tmp[i - 1 - j]);
            }
            tmp[i] = res;
        }
        return tmp[n];
    }
}
