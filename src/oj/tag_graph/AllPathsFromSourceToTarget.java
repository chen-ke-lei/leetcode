package oj.tag_graph;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), graph, 0);
        return res;
    }

    void dfs(List<List<Integer>> res, List<Integer> tmp, int[][] graph, int node) {
        if (graph[node].length == 0||node==graph.length-1) {
            if(node==graph.length-1){
                res.add(new ArrayList<>(tmp));
                res.get(res.size() - 1).add(node);
            }

        } else {
            tmp.add(node);
            for (int i = 0; i < graph[node].length; i++) {
                dfs(res, tmp, graph, graph[node][i]);
            }
            tmp.remove(tmp.size() - 1);
        }

    }
}
