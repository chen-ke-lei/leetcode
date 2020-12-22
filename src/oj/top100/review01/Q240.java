package oj.top100.review01;

public class Q240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int length = matrix.length, sublength = matrix[0].length;
        if (matrix[0][0] == target || matrix[length - 1][sublength - 1] == target) return true;
        if (matrix[0][0] > target || matrix[length - 1][sublength - 1] < target) return false;
        if (matrix[0][sublength - 1] == target || matrix[length - 1][0] == target) return true;
        
        int startA = 0, endA = length - 1;
        if (matrix[length - 1][0] < target) startA = length - 1;
        else {
            while (startA < endA) {
                int tmp = (startA + endA) / 2;
                if (matrix[tmp][0] < target) {
                    startA = tmp;
                } else if (matrix[tmp][0] == target) return true;
                else
                    endA = tmp;
                if (startA + 1 == endA) {
                    break;
                }
            }
        }

        int startB = 0, endB = length - 1;
        if (matrix[0][sublength - 1] < target) endB = 0;
        else {
            while (startB < endB) {
                int tmp = (startB + endB) / 2;
                if (matrix[tmp][sublength - 1] == target) return true;
                else if (matrix[tmp][sublength - 1] < target) startB = tmp;
                else endB = tmp;
                if (startB + 1 == endB) break;
            }
        }

        for (int i = endB; i <= startA; i++) {
            int[] array = matrix[i];
            int left = 0, right = sublength - 1;
            if (array[0] == target || array[right] == target) return true;
            while (left < right) {
                int tmp = (left + right) / 2;
                if (array[tmp] == target) return true;
                if (array[tmp] < target) left = tmp + 1;
                else right = tmp;
            }
        }

        return false;
    }
}
