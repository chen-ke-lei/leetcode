package oj.hot200;

import java.util.*;

public class Q356 {
    public boolean isReflected(int[][] points) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<String> vis = new HashSet<>();
        for (int[] point : points) {
            if (vis.contains(point[0] + "_" + point[1])) continue;
            if (!map.containsKey(point[1])) map.put(point[1], new ArrayList<>());
            map.get(point[1]).add(point[0]);
            vis.add(point[0] + "_" + point[1]);
        }
        double mid = Double.MAX_VALUE;
        for (Integer integer : map.keySet()) {
            List<Integer> integers = map.get(integer);
            integers.sort((a, b) -> a - b);
            if (integers.size() % 2 == 1) {
                if (mid == Double.MAX_VALUE) {
                    mid = integers.get(integers.size() / 2);
                } else {
                    if (mid != integers.get(integers.size() / 2)) return false;
                }

            }
            for (int i = 0; i < integers.size() / 2; i++) {
                if (mid == Double.MAX_VALUE)
                    mid = (integers.get(i) + integers.get(integers.size() - 1 - i)) / 2.0;
                else {
                    if (mid != (integers.get(i) + integers.get(integers.size() - 1 - i)) / 2.0) return false;
                }
            }

        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Q356().isReflected(new int[][]{{1, 1}, {9, 1}, {8, 2}})); ;
    }
}
