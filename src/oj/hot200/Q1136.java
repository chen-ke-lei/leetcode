package oj.hot200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q1136 {
    public int minimumSemesters(int N, int[][] relations) {
        int res = 0;
        Set<Integer>[] graph = new Set[N];
        for (int[] relation : relations) {
            if (graph[relation[1] - 1] == null) graph[relation[1] - 1] = new HashSet<>();
            if (graph[relation[0] - 1] == null) graph[relation[0] - 1] = new HashSet<>();
            graph[relation[1] - 1].add(relation[0] - 1);
        }
        while (true) {
            int zeroNum = 0;
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < graph.length; i++) {
                if (graph[i] == null) continue;
                zeroNum++;
                if (graph[i].isEmpty()) {
                    tmp.add(i);
                    graph[i] = null;
                }

            }

            if (zeroNum == 0) return res;
            if (tmp.isEmpty()) return -1;
            res++;
            for (Set<Integer> set : graph) {
                if (set == null || set.isEmpty()) continue;
                for (Integer integer : tmp) {
                    if (set.contains(integer)) set.remove(integer);
                }
            }

        }
    }

}
