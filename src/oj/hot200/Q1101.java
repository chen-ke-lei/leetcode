package oj.hot200;

import java.util.*;

public class Q1101 {
    public int earliestAcq(int[][] logs, int N) {
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        Map<Integer, List<Integer>> subUnion = new HashMap<>();
        Map<Integer, Integer> vMap = new HashMap<>();
        for (int[] log : logs) {
            int a = log[1];
            int b = log[2];
            if (!vMap.containsKey(a) && !vMap.containsKey(b)) {
                vMap.put(a, a);
                vMap.put(b, a);
                subUnion.put(a, new ArrayList<>());
                subUnion.get(a).add(a);
                subUnion.get(a).add(b);
            } else if (vMap.containsKey(a) && vMap.containsKey(b)) {
                int nodeA = vMap.get(a);
                int nodeB = vMap.get(b);
                if (nodeA != nodeB) {
                    List<Integer> bList = subUnion.get(nodeB);
                    for (Integer integer : bList) {
                        vMap.put(integer, nodeA);

                    }
                    subUnion.get(nodeA).addAll(bList);
                    subUnion.remove(nodeB);
                }
            } else {
                if (vMap.containsKey(a)) {
                    vMap.put(b, vMap.get(a));
                    subUnion.get(vMap.get(a)).add(b);
                } else {
                    vMap.put(a, vMap.get(b));
                    subUnion.get(vMap.get(b)).add(a);
                }
            }
            if (subUnion.size() == 1 && subUnion.values().iterator().next().size() == N) return log[0];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Q1101().earliestAcq(new int[][]{{20190101, 0, 1}
                , {20190104, 3, 4}
                , {20190107, 2, 3}
                , {20190211, 1, 5}
                , {20190224, 2, 4}
                , {20190301, 0, 3}
                , {20190312, 1, 2}, {20190322, 4, 5}}, 6));
    }
}
