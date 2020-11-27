package oj.hot200;

public class Q308 {
    class NumMatrix {
        int[][] matrix;
        int[][] subMax;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i].length == 0) continue;
                subMax[i][0] = matrix[i][0];
                for (int j = 1; j < matrix[i].length; j++) {
                    subMax[i][j] = subMax[i][j - 1] + matrix[i][j];
                }
            }
        }

        public void update(int row, int col, int val) {
            int sub = val - matrix[row][col];
            matrix[row][col] = val;
            for (int i = col; i < matrix[row].length; i++)
                subMax[col][row] += val;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int tmp = 0;
            for (int i = row1; i <= row2; i++) {
                int a = 0;
                if (col1 != 0) a = subMax[i][col1 - 1];
                tmp += (subMax[i][col2] - a);
            }

            return tmp;
        }
    }

}
