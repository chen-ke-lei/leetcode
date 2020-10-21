package oj.cap211;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Q4 {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        if (queries.length == 0) return new ArrayList<>();
        List<Boolean> res = new ArrayList<>();
        int[][] graph = new int[n][n];
        for (int i = 1; i < n; i++) {
            if (i <= threshold) continue;
            for (int j = i + 1; j <= n; j++) {
                if (getNumber(i, j) > threshold) {
                    graph[i - 1][j - 1] = 1;
                    graph[j - 1][i - 1] = 1;
                }
            }
        }
        boolean[] vis = new boolean[n];
        for (int[] que : queries) {
            if (graph[que[0] - 1][que[1] - 1] == 1)
                res.add(true);
            else if (!vis[que[0] - 1]) {
                Set<Integer> set = new HashSet<>();
                dfs(set, vis, graph, que[0] - 1);
                for (Integer i : set) {
                    if (i != que[0] - 1) {
                        graph[i][que[0] - 1] = 1;
                        graph[que[0] - 1][i] = 1;
                    }
                }
                if (set.contains(que[1] - 1)) res.add(true);
                else res.add(false);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    int getNumber(int x, int y) {

        if (x == y) {
            return x;
        }
        int big = x > y ? x : y;
        int small = x < y ? x : y;
        return getNumber(big - small, small);
    }

    void dfs(Set<Integer> path, boolean[] vis, int[][] graph, int node) {
        if (vis[node] == true) return;
        vis[node] = true;
        for (int i = 0; i < graph[node].length; i++) {
            if (graph[node][i] == 1) {
                path.add(i);
                dfs(path, vis, graph, i);
            }

        }
    }

}
