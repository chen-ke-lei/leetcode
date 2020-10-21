package oj.tag_graph;

import java.util.ArrayList;
import java.util.List;

public class RouteBetweenNodesLCCI {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        List<List<Integer>> table = new ArrayList<>();
        for (int i = 0; i < n; i++)
            table.add(new ArrayList<>());
        for (int i = 0; i < graph.length; i++)
            table.get(graph[i][0]).add(graph[i][1]);

        return dfs(table, new boolean[n], start, target);
    }

    boolean dfs(List<List<Integer>> matrix, boolean[] v, int i, int j) {
        if (v[i])
            return false;
        v[i] = true;
        if (matrix.get(i).contains(j)) return true;
        for (int k = 0; k < matrix.get(i).size(); k++) {
            if (dfs(matrix, v, matrix.get(i).get(k), j)) return true;
        }
        v[i] = false;
        return false;
    }
}
