package oj.hot200;

public class Q323 {
    public int countComponents(int n, int[][] edges) {
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        int res = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            res++;
            //    vis[i] = true;
            dfs(graph, i, vis);
        }
        return res;
    }

    void dfs(int[][] graph, int i, boolean[] vis) {
        if (vis[i]) return;
        vis[i] = true;
        for (int j = 0; j < graph.length; j++) {
            if (graph[i][j] == 1) dfs(graph, j, vis);
        }
    }
}
