package oj.tag_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] graph = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]][edges[i][1]] = edges[i][2];
            graph[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> tmp = new ArrayList<>();
            dfs(graph, new boolean[n], i, distanceThreshold, tmp);
            res.add(tmp);
        }
     //   System.out.println(res);
        int no = 0, num = res.get(0).size();
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i).size() <= num) {
                no = i;
                num = res.get(i).size();
            }
        }
        return no;

    }

    void dfs(int[][] graph, boolean[] vis, int node, int distanceThreshold, List<Integer> list) {
     //   System.out.println(Arrays.toString(vis));
        if (vis[node]) return;
        vis[node] = true;
        for (int i = 0; i < graph[node].length; i++) {
            if (graph[node][i] > 0 && distanceThreshold >= graph[node][i]&&!vis[i]) {
                list.add(i);
                dfs(graph, vis, i, distanceThreshold - graph[node][i], list);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance()
                .findTheCity(5,
                        new int[][]{{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}},
                        2));
    }

}
