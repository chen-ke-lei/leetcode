package oj.top100.review01;

public class Q200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    void dfs(char[][] grid, int i, int j) {
        if (grid[i][j] != '1') return;
        grid[i][j] = '0';
        if (i > 0) dfs(grid, i - 1, j);
        if (j > 0) dfs(grid, i, j - 1);
        if (i < grid.length - 1) dfs(grid, i + 1, j);
        if (j < grid[i].length - 1) dfs(grid, i, j + 1);
    }
}
