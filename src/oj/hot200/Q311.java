package oj.hot200;

public class Q311 {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[A.length][B[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                int tmp = 0;
                for (int k = 0; k < A[i].length; k++) {
                    tmp += A[i][k] * B[k][j];
                }
                res[i][j] = tmp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Q311().multiply(new int[][]{{1, 0, 0}, {-1, 0, 3}},
                new int[][]{{7, 0, 0}, {0, 0, 0}, {0, 0, 1}});
    }
}
