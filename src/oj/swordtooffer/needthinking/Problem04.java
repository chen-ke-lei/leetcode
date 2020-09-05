package oj.swordtooffer.needthinking;

public class Problem04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target)
                return false;
            if (binarySelect(matrix[i], target))
                return true;
        }

        return false;
    }

    boolean binarySelect(int[] arrary, int target) {
        int left = 0, right = arrary.length - 1;
        if (arrary[0] == target || arrary[right] == target)
            return true;
        if (arrary[0] > target || arrary[right] < target)
            return false;
        while (left < right) {
            int tmp = (left + right) / 2;
            if (tmp == left)
                return false;
            if (arrary[tmp] == target)
                return true;
            if (arrary[tmp] < target)
                left = target;
            else
                right = target;
        }
        return false;
    }
}
