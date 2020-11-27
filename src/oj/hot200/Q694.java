package oj.hot200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q694 {
    public int numDistinctIslands(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        Set<String> res = new HashSet<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (!vis[i][j] && grid[i][j] == 1) {
                    List<Integer> tmp = new ArrayList<>();
                    dfs(grid, vis, i, j, tmp);
                    resList.add(tmp);
                }
        for (List<Integer> list : resList) {
            if (list.size() >= 2) {
                System.out.println(list);
                int a = list.get(0), b = list.get(1);
                list.set(0, 0);
                list.set(1, 0);
                for (int i = 2; i < list.size(); i += 2) {
                    list.set(i, list.get(i) - a);
                    list.set(i + 1, list.get(i + 1) - b);
                }
                System.out.println(list);
                res.add(list.toString());
            }
        }
        return res.size();
    }

    void dfs(int[][] grid, boolean[][] vis, int i, int j, List<Integer> tmp) {
        if (vis[i][j] || grid[i][j] == 0) return;
        vis[i][j] = true;
        tmp.add(i);
        tmp.add(j);
        if (i > 0) dfs(grid, vis, i - 1, j, tmp);
        if (j > 0) dfs(grid, vis, i, j - 1, tmp);
        if (i < grid.length - 1) dfs(grid, vis, i + 1, j, tmp);
        if (j < grid[i].length - 1) dfs(grid, vis, i, j + 1, tmp);

    }

    public static void main(String[] args) {
        System.out.println(new Q694().numDistinctIslands(new int[][]{{0,1}}));
    }
}
