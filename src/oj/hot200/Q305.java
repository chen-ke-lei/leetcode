package oj.hot200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q305 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        Map<String, List<String>> islandMap = new HashMap<>();
        Map<String, String> point = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int[] position : positions) {
            union(islandMap, point, position);
            res.add(islandMap.size());
        }

        return res;
    }

    void union(Map<String, List<String>> islandMap, Map<String, String> point, int[] position) {
        String ps = (position[0]) + "_" + (position[1]);
        String[] site = new String[]{
                (position[0] - 1) + "_" + (position[1]), (position[0] + 1) + "_" + (position[1]),
                (position[0]) + "_" + (position[1] - 1), (position[0]) + "_" + (position[1] + 1)
        };
        String node = null;
        for (String s : site) {
            if (!point.containsKey(s)) continue;
            if (node == null) {
                node = point.get(s);
                point.put(ps, node);
                islandMap.get(node).add(ps);
            } else {
                String tmp = point.get(s);
                if (tmp.equals(node)) continue;
                List<String> list = islandMap.get(tmp);
                for (String s1 : list) {
                    point.put(s1, node);
                    islandMap.get(node).add(s1);
                }
                islandMap.remove(tmp);
            }
        }
        if (node == null) {
            point.put(ps, ps);
            islandMap.put(ps, new ArrayList<>());
            islandMap.get(ps).add(ps);
        }
    }
}
