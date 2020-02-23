package oj.newcoder;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int[] path = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) {
                    path[i] = grid[i][j];
                } else if (i == 0) {
                    path[j] = path[j - 1] + grid[i][j];
                } else if (j == 0) {
                    path[j] += grid[i][j];
                } else {
                    path[j] = grid[i][j] + (path[j]>path[j-1]?path[j-1]:path[j]);
                }
            }
        }
        return path[path.length - 1];
    }
}
