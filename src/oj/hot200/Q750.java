package oj.hot200;

public class Q750 {
    public int countCornerRectangles(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[i].length - 1; j++) {
                if (grid[i][j] == 0) continue;
                for (int k = 1; i + k < grid.length && k + j < grid[i].length; k++) {
                    if (grid[i + k][j] == 1 && grid[i][j + k] == 1 && grid[i + k][j + k] == 1)
                        res++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q750().countCornerRectangles(new int[][]{{0, 1, 0}, {1, 0, 1}, {1, 0, 1}, {0, 1, 0}}));
    }
}
