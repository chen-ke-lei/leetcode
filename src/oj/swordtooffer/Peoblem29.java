package oj.swordtooffer;

import java.util.Arrays;

public class Peoblem29 {
    public static void main(String[] av) {
        System.out.println(Arrays.toString(new Peoblem29().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new int[0];
        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0;
        for (int i = 0; i < (matrix.length + 1) / 2; i++) {
            for (int j = i; j < matrix.length - i; j++)
                res[index++] = matrix[i][j];
            if (index == res.length)
                return res;
            for (int j = i + 1; j < matrix.length - i - 1; j++)
                res[index++] = matrix[j][matrix.length - i - 1];
            if (index == res.length)
                return res;
            for (int j = matrix.length - i - 1; j >= i; j--)
                res[index++] = matrix[matrix.length - i - 1][j];
            if (index == res.length)
                return res;
            for (int j = matrix.length - 2 - i; j > i; j--)
                res[index++] = matrix[j][i];
        }
        return res;
    }
}
