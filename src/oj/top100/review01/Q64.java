package oj.top100.review01;

public class Q64 {
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) continue;
                int tmp = Math.min(i > 0 ? grid[i - 1][j] : Integer.MAX_VALUE, j > 0 ? grid[i][j - 1] : Integer.MAX_VALUE);
                grid[i][j] += tmp;
            }
        }

        return grid[grid.length - 1][grid[grid.length - 1].length - 1];
    }

}
