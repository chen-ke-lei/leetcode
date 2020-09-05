package oj.swordtooffer;

public class Problem13 {

    int res = 0;

    public int movingCount(int m, int n, int k) {
        if (k == 0)
            return 1;
        boolean[][] sign = new boolean[m][n];
        dfs(sign, 0, 0, k);
        return res;
    }

    void dfs(boolean[][] sign, int i, int j, int k) {
        sign[i][j] = true;
        res++;
        if (i > 0 && !sign[i - 1][j] && cal(i - 1) + cal(j) <= k) dfs(sign, i - 1, j, k);
        if (i < sign.length - 1 && !sign[i + 1][j] && cal(i + 1) + cal(j) <= k) dfs(sign, i + 1, j, k);
        if (j > 0 && !sign[i][j - 1] && cal(i) + cal(j - 1) <= k) dfs(sign, i, j - 1, k);
        if (j < sign[i].length - 1 && !sign[i][j + 1] && cal(i) + cal(j + 1) <= k) dfs(sign, i, j + 1, k);
    }

    int cal(int i) {
        int num = 0;
        while (i > 0) {
            num += (i % 10);
            i /= 10;
        }
        return num;
    }
}
