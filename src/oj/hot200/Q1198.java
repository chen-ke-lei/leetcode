package oj.hot200;

import java.util.ArrayList;
import java.util.List;

public class Q1198 {
    public int smallestCommonElement(int[][] mat) {
        List<Integer> tmp = new ArrayList<>(), pre = new ArrayList<>();
        for (int i = 0; i < mat[0].length; i++)
            tmp.add(mat[0][i]);
        for (int k = 1; k < mat.length; k++) {
            int i = 0, j = 0;
            while (i < tmp.size() && j < mat[k].length) {
                if (tmp.get(i) < mat[k][j]) i++;
                else if (tmp.get(i) > mat[k][j]) j++;
                else {
                    pre.add(tmp.get(i));
                    i++;
                    j++;
                }
            }
            if (pre.isEmpty()) return -1;
            tmp = pre;
            pre = new ArrayList<>();
        }
        return tmp.get(0);
    }
}
