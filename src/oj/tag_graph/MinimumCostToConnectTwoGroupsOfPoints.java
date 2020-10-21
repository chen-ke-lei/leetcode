package oj.tag_graph;

import java.util.ArrayList;
import java.util.List;

public class MinimumCostToConnectTwoGroupsOfPoints {
    public int connectTwoGroups(List<List<Integer>> cost) {
        List<int[]> edgs = new ArrayList<>();
        for (int i = 0; i < cost.size(); i++)
            for (int j = 0; j < cost.get(i).size(); j++) {
                int[] edg = new int[3];
                edg[0] = cost.get(i).get(j);
                edg[1] = i;
                edg[2] = j;
                edgs.add(edg);
            }
        edgs.sort((x1, x2) -> {
            return x1[0] - x2[0];
        });
        boolean[] A = new boolean[cost.size()], B = new boolean[cost.get(0).size()];
        int a = A.length, b = B.length;
        int resB = 0;
        for (int[] edg : edgs) {
            if ( !B[edg[2]]) {
                resB += edg[0];

                if (!B[edg[2]]) {
                    B[edg[2]] = true;
                    b--;
                }
            }
            if ( b == 0)
                break;
        }
        int resA = 0;
        for (int[] edg : edgs) {
            if ( !A[edg[1]]) {
                resA += edg[0];

                if (!A[edg[1]]) {
                    A[edg[1]] = true;
                    a--;
                }
            }
            if ( a == 0)
                break;
        }

        return Math.min(resA,resB);

    }
}
