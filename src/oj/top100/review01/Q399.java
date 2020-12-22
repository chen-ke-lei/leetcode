package oj.top100.review01;

import java.util.*;

public class Q399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> map = new HashMap<>();
        for (List<String> equation : equations) {
            if (!map.containsKey(equation.get(0))) map.put(equation.get(0), map.size());
            if (!map.containsKey(equation.get(1))) map.put(equation.get(1), map.size());
        }
        double[] vals = new double[map.size()];
        double[][] graph = new double[map.size()][map.size()];
        for (int i = 0; i < equations.size(); i++) {
            List<String> list = equations.get(i);
            int a = map.get(list.get(0));
            int b = map.get(list.get(1));
            graph[a][b] = values[i];
            graph[b][a] = 1 / values[i];
        }
        boolean[] vis = new boolean[map.size()];
        double[] res = new double[queries.size()];
        Arrays.fill(res, -1);
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                vals = new double[map.size()];
                vals[i] = 1.0;
                dfs(vis, i, graph, vals);
                for (int k = 0; k < res.length; k++) {
                    List<String> list = queries.get(k);
                    if (res[k] != -1) continue;
                    if (!map.containsKey(list.get(0)) || !map.containsKey(list.get(1))) continue;
                    if (vals[map.get(list.get(0))] == 0 || vals[map.get(list.get(1))] == 0)
                        continue;
                    res[k] = vals[map.get(list.get(0))] / vals[map.get(list.get(1))];
                }
            }
        }
        return res;
    }

    void dfs(boolean[] vis, int i, double[][] graph, double[] val) {
        if (vis[i]) return;
        vis[i] = true;
        for (int j = 0; j < graph[i].length; j++) {
            if (!vis[j] && graph[i][j] != 0) {
                val[j] = val[i] / graph[i][j];
                dfs(vis, j, graph, val);
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Arrays.asList(new String[]{"a", "b"}));
        lists.add(Arrays.asList(new String[]{"b", "c"}));

    }
}
