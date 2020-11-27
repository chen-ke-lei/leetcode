package oj.interview_tips;

public class Q10_09 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int lenI = matrix.length, lenJ = matrix[0].length;
        if (matrix[0][0] > target || matrix[lenI - 1][lenJ - 1] < target) return false;
        if (matrix[0][0] == target
                || matrix[lenI - 1][0] == target
                || matrix[0][lenJ - 1] == target
                || matrix[lenI - 1][lenJ - 1] == target)
            return true;
        int left = 0, right = lenI - 1, end = right;
        while (left < right) {
            int tmp = (left + right) / 2;
            if (matrix[tmp][0] == target) return true;
            if (matrix[tmp][0] > target) {
                right = tmp;
            } else {
                if (tmp == left) {
                    end = tmp;
                    break;
                }
                left = end;
            }
        }
        left = 0;
        right = lenI - 1;
        int beg = 0;
        while (left < right) {
            int tmp = (left + right) / 2;
            if (matrix[tmp][lenJ - 1] == target) return true;
            if (matrix[tmp][lenJ - 1] > target) {
                right = tmp;
            } else {
                if (tmp == left) {
                    beg = right;
                    break;
                } else {
                    left = tmp;
                }
            }
        }
        for (int i = beg; i <= end; i++) {
            if (binarySearch(matrix[i], target)) return true;
        }
        return false;

    }

    boolean binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int tmp = (left + right) / 2;
            if (nums[tmp] == target) return true;
            if (nums[tmp] > target) right = tmp;
            else left = tmp + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Q10_09().searchMatrix(new int[][]{{5}, {6}}, 6));
    }
}
