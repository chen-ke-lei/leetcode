package oj.tag_graph;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0)return 0;
        int[][] tmp = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    tmp[i][j]=1;
                    if (j > 0) tmp[i][j] += tmp[i][j - 1] ;
                    int min = tmp[i][j];
                    for (int k = i; k >= 0; k--) {
                        if (tmp[k][j] == 0) break;
                        min = Math.min(min, tmp[k][j]);
                        res = res > (i - k + 1) * min ? res : (i - k + 1) * min;
                    }
                }
            }
        return res;
    }
}
