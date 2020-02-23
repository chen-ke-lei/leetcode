package oj.newcoder;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
            return 0;
        int[] path = new int[obstacleGrid[0].length];
        path[0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    path[j] = 0;
                } else {
                    if (j > 0)
                        path[j] += path[j - 1];
                }
            }
        }

        return path[path.length - 1];
    }
}
