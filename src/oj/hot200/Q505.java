package oj.hot200;

public class Q505 {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        for (int[] ints : maze) {
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] == 1) ints[i] = -1;
                else ints[i] = Integer.MAX_VALUE;
            }
        }
        dfs(maze, start[0], start[1], 0);
        return maze[destination[0]][destination[1]] == 0 ? -1 : maze[destination[0]][destination[1]];
    }

    void dfs(int[][] maze, int i, int j, int step) {
        if (maze[i][j] == -1 || step > maze[i][j]) return;
        maze[i][j] = step;
        if (i > 0) dfs(maze, i - 1, j, step + 1);
        if (i < maze.length - 1) dfs(maze, i + 1, j, step + 1);
        if (j > 0) dfs(maze, i, j - 1, step + 1);
        if (j < maze[i].length - 1) dfs(maze, i, j + 1, step + 1);

    }
}
