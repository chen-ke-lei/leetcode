package oj.interview_tips;

import java.util.Arrays;

public class Q01_08 {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int[][] sign = new int[Math.max(matrix.length, matrix[0].length)][2];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    sign[i][0] = 1;
                    sign[j][1] = 0;
                }
            }
        for (int i = 0; i < sign.length; i++) {
            if (sign[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
            if (sign[i][1] == 0) {
                for (int j = 0; j < matrix.length; j++)
                    matrix[j][i] = 0;
            }
        }
    }
}
