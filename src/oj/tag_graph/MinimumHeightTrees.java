package oj.tag_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i != j)
                    graph[i][j] = n + 1;
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]][edges[i][1]] = 1;
            graph[edges[i][1]][edges[i][0]] = 1;
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++) {
                    graph[j][k] = graph[j][k] < graph[j][i] + graph[i][k] ? graph[j][k] : graph[j][i] + graph[i][k];
                }
//        for (int i = 0; i < n; i++)
//            System.out.println(Arrays.toString(graph[i]));
        int min = n;
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                if (graph[i][j] > tmp)
                    tmp = graph[i][j];
            }
            v[i] = tmp;
            min = min < tmp ? min : tmp;
        }
        for (int i = 0; i < n; i++)
            if (v[i] == min)
                res.add(i);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumHeightTrees().findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}));
    }
}
