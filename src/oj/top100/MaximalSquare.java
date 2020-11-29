package oj.top100;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int res = 0;
        int[][] sub = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++) {
                int num = matrix[i][j] - '0';
                if (i == 0 || j == 0)
                    sub[i][j] = num;
                else {
                    if (num == 0) {
                        sub[i][j] = 0;
                    } else {
                        sub[i][j] = 1 + Math.min(Math.min(sub[i - 1][j], sub[i][j - 1]), sub[i - 1][j - 1]);
                    }
                }
                res = res > sub[i][j] ? res : sub[i][j];
            }
        return res * res;
    }
}
