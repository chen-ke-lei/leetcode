package oj.interview_tips;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q08_12 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        dfs(res, 0, new int[n][n], new ArrayList<>());
        return res;
    }

    void dfs(List<List<String>> res, int i, int[][] site, List<String> tmp) {
        if (i >= site.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int j = 0; j < site[i].length; j++) {
            if (site[i][j] == 0) {
                cal(site, i, j, 1);
                display(site);
                tmp.add(generateQ(j, site.length));

                dfs(res, i + 1, site, tmp);
                tmp.remove(tmp.size() - 1);
                cal(site, i, j, -1);
            }
        }
    }

    String generateQ(int i, int n) {
        StringBuffer buffer = new StringBuffer();
        for (int j = 0; j < n; j++) {
            if (j == i) buffer.append("Q");
            else buffer.append(".");
        }
        return buffer.toString();
    }

    void cal(int[][] site, int i, int j, int sign) {
        for (int tmp = i; tmp < site.length; tmp++)
            site[tmp][j] += sign;
        for (int tmp = j + 1; tmp < site[i].length; tmp++)
            site[i][tmp] += sign;
        for (int tmpI = i + 1, tmpJ = j + 1; tmpI < site.length && tmpJ < site.length; tmpI++, tmpJ++) {
            site[tmpI][tmpJ] += sign;
        }
        for (int tmpI = i + 1, tmpJ = j - 1; tmpI < site.length && tmpJ >= 0; tmpI++, tmpJ--)
            site[tmpI][tmpJ] += sign;
    }

    void display(int[][] site) {
        for (int[] ints : site) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("======================");
    }

    public static void main(String[] args) {
        System.out.println(new Q08_12().solveNQueens(4));
    }
}
