package oj.tag_graph;

import java.util.HashSet;
import java.util.Set;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        //    Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++)
            if (!vis[i])
                if (!dfs(graph, i, new HashSet<>(), new HashSet<>(), vis)) return false;

        return true;
    }

    boolean dfs(int[][] graph, int node, Set<Integer> set1, Set<Integer> set2, boolean[] vis) {
        if (set2.contains(node)) return false;
        if (vis[node]) return true;
        vis[node] = true;
        set1.add(node);
        for (int i = 0; i < graph[node].length; i++) {
            if (!dfs(graph, graph[node][i], set2, set1, vis)) return false;
        }

        return true;
    }
}
