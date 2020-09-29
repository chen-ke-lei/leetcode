package oj.hot100;

public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int beg = 0, end = matrix.length - 1;
        while (beg < end) {
            if (matrix[beg][0] == target || matrix[end][0] == target)
                return true;
            if (matrix[beg][0] > target)
                return false;
            if (matrix[end][0] < target)
                break;
            int mid = (beg + end) / 2;
            if (matrix[mid][0] == target)
                return true;

        }
        return false;
    }


}
