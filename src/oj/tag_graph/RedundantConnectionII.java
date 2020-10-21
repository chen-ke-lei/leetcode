package oj.tag_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedundantConnectionII {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        Map<String, Integer> edg2Index = new HashMap<>();
        for (int i = 0; i < edges.length; i++)
            edg2Index.put((edges[i][0] - 1) + "," + (edges[i][1] - 1), i);
        int[][] graph = new int[edges.length][edges.length];
        for (int i = 0; i < edges.length; i++)
            graph[edges[i][0] - 1][edges[i][1] - 1] = 1;
        boolean[] vis = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            if (!vis[i]) {
                List<String> path = new ArrayList<>();
                if (dfs(path, graph, i, vis)) {
                    int index = -1;
                    for (int j = 0; j < path.size(); j++) {
                        index = index > edg2Index.get(path.get(i)) ? index : edg2Index.get(path.get(i));
                        return edges[index];
                    }
                    break;
                }
            }
        }

        return null;
    }

    boolean dfs(List<String> edg, int[][] graph, int node, boolean[] vis) {
        if (vis[node]) return true;
        vis[node] = true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[node][i] == 1) {
                edg.add(node + "," + graph[node][i]);
                if (dfs(edg, graph, graph[node][i], vis)) return true;
                edg.remove(edg.size() - 1);
            }
        }
        return false;
    }
}
