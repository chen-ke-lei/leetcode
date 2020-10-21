package oj.tag_graph;

import java.util.ArrayList;
import java.util.List;

public class FlowerPlantingWithNoAdjacent {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] res = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        boolean[] vis = new boolean[n];
        for (int[] path : paths) {
            graph.get(path[0] - 1).add(path[1] - 1);
            graph.get(path[1] - 1).add(path[0] - 1);
        }
        dfs(0,graph,vis,res);
        return res;
    }

    void dfs(int i, List<List<Integer>> graph, boolean[] vis, int[] res) {
        if (vis[i]) return;
        vis[i] = true;
        List<Integer> list = graph.get(i);
        boolean[] nums = new boolean[4];
        if (res[i] > 0) nums[res[i] - 1] = true;
        for (int j = 0; j < list.size(); j++)
            if (res[list.get(j)] > 0) nums[res[list.get(j)] - 1] = true;
        int index = 0;
        for (int j = 0; j < list.size(); j++) {
            if (res[list.get(j)] == 0) {
                while (nums[index])
                    index++;
                res[list.get(j)] = index + 1;
                nums[index] = true;

            }
        }
        for (int j = 0; j < list.size(); j++)
            dfs(list.get(i), graph, vis, res);
    }
}
