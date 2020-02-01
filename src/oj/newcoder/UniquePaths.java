package oj.newcoder;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] path = new int[n];
        path[0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0)
                    path[j] = 1;
                else {
                    if (i > 0&&j>0)
                        path[j] += path[j - 1];
                }
            }

        }
        return path[n - 1];

    }
}
