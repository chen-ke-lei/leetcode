package oj.hot200;

public class Q562 {
    public int longestLine(int[][] M) {
        if (M.length == 0 || M[0].length == 0) return 0;
        int res = 0;
        for (int i = 0; i < M.length; i++) {
            int sub = 0;
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 0) {
                    sub = 0;
                } else {
                    sub++;
                }
                res = res > sub ? res : sub;
            }

        }

        for (int i = 0; i < M[0].length; i++) {
            int sub = 0;
            for (int j = 0; j < M.length; j++) {
                if (M[j][i] == 0) {
                    sub = 0;
                } else {
                    sub += 1;
                }
                res = res > sub ? res : sub;
            }
        }

        for (int j = 0; j < M[0].length; j++) {
            int sub = 0;
            for (int i = 0; i < M.length && i + j < M[i].length; i++) {
                if (M[i][j + i] == 0) {
                    sub = 0;
                } else {
                    sub++;
                }
                res = res > sub ? res : sub;
            }
            sub = 0;
            for (int i = 0; i < M.length && j - i >= 0; i++) {
                if (M[i][j - i] == 0) {
                    sub = 0;
                } else {
                    sub++;
                }
                res = res > sub ? res : sub;
            }
        }
        for (int i = 1; i < M.length; i++) {
            int sub = 0;
            for (int j = 0; i + j < M.length && j < M[i + j].length; j++) {
                if (M[i + j][j] == 0) sub = 0;
                else sub++;
                res = res > sub ? res : sub;
            }
            sub = 0;
            for (int j = M[i].length - 1; j >= 0 && i + M[i].length - 1 - j < M.length; j--) {
                if (M[i + M[i].length - 1 - j][j] == 0) sub = 0;
                else sub++;
                res = res > sub ? res : sub;
            }
        }

        return res;
    }
}
