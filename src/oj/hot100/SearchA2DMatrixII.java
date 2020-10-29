package oj.hot100;

public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) return false;
        if (matrix[0][0] == target
                || matrix[matrix.length - 1][0] == target
                || matrix[0][matrix[0].length - 1] == target
                || matrix[matrix.length - 1][matrix[0].length - 1] == target) return true;
        if (matrix[0][0] > target || matrix[matrix.length - 1][matrix[0].length - 1] < target) return false;
        int up = 0, down = matrix.length - 1;
        int beg = 0, end = 0;
        while (up < down) {
            int tmp = (up + down) / 2;
            if (matrix[tmp][0] == target) return true;
            if (matrix[tmp][0] > target) {
                down = tmp;
            } else {
                up = tmp + 1;

            }

        }
        if (matrix[up][0] < target) end = up;
        else if (matrix[down][0] < target) end = down;

        up = 0;
        down = matrix.length - 1;
        while (up < down) {
            int tmp = (up + down) / 2;
            if (matrix[tmp][matrix[0].length - 1] == target) return true;
            if (matrix[tmp][matrix[0].length - 1] < target) {
                up = tmp + 1;
            } else {
                down = tmp;

            }
            //   System.out.println(up);

        }
        if (matrix[down][matrix[0].length - 1] > target) beg = down;
        else if (matrix[up][matrix[0].length - 1] > target) beg = up;


        System.out.println(beg + "  " + end);
        for (int i = beg; i <= end; i++) {
            int[] nums = matrix[i];
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int tmp = (left + right) / 2;
                if (nums[tmp] == target) return true;
                if (nums[tmp] < target) {
                    left = tmp + 1;
                } else {
                    right = tmp;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SearchA2DMatrixII().searchMatrix(
                new int[][]{{1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}},
                5

        ));

        System.out.println(new SearchA2DMatrixII().searchMatrix(
                new int[][]{{1},
                        {2},
                        {3},
                        {4},
                        {5},
                },
                4

        ));

    }

}
