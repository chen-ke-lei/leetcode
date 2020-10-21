package oj.tag_graph;

import java.util.Arrays;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] site = new int[edges.length];
        for (int[] e : edges) {
            site[e[0] - 1]++;
            site[e[1] - 1]++;
        }
//        System.out.println(Arrays.toString(site));
////        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < site.length; i++) {
//            if (site[i] % 2 == 0)
//                set.add(i + 1);
//        }

        for (int i = edges.length - 1; i >= 0; i--) {
            if (site[edges[i][0] - 1] > 1 && site[edges[i][1]-1] > 1) return edges[i];
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RedundantConnection().findRedundantConnection
                (new int[][]{{1, 2}, {1, 3}, {2, 3}})));
    }
}
