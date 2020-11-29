package oj.top100;

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
        if (matrix[down][0] < target) end = down;
        else
            while (up < down) {
                int tmp = (up + down) / 2;
                if (matrix[tmp][0] == target) return true;
                if (matrix[tmp][0] > target) {
                    down = tmp;
                } else {
                    if (tmp == up) {
                        end = tmp;
                        break;
                    }
                    up = tmp;

                }

            }
        up = 0;
        down = matrix.length - 1;
        while (up < down) {
            int tmp = (up + down) / 2;
            if (matrix[tmp][matrix[0].length - 1] == target) return true;
            if (matrix[tmp][matrix[0].length - 1] < target) {
                if (up == tmp) {
                    beg = down;
                    break;
                }
                up = tmp;
            } else {
                down = tmp;

            }

        }
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
                new int[][]{{1, 3, 5, 7, 9}
                        , {2, 4, 6, 8, 10}
                        , {11, 13, 15, 17, 19}
                        , {12, 14, 16, 18, 20}
                        , {21, 22, 23, 24, 25}},
                24

        ));

//        System.out.println(new SearchA2DMatrixII().searchMatrix(
//                new int[][]{{1},
//                        {2},
//                        {3},
//                        {4},
//                        {5},
//                },
//                4
//
//        ));

    }

}
