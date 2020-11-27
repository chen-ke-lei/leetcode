package oj.hot200;

public class Q261 {
    public boolean validTree(int n, int[][] edges) {
        boolean[] vis = new boolean[n];
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }

        return dfs(graph, new boolean[n], 0);
    }

    boolean dfs(int[][] graph, boolean[] vis, int i) {
        if (vis[i]) return false;
        vis[i] = true;
        for (int j = i + 1; j < graph.length; j++)
            if (graph[i][j] == 1 && !dfs(graph, vis, j)) return false;
        vis[i] = false;
        return true;
    }
}
