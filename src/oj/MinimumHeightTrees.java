package oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        int[] verges = new int[n];
        boolean hasLeft = true;
        for (int i = 0; i < edges.length; i++) {
            verges[edges[i][0]]++;
            verges[edges[i][1]]++;
        }
        while (hasLeft) {
            System.out.println(Arrays.toString(verges));
            hasLeft = false;
            for (int i = 0; i < n; i++) {
                if (verges[i] > 1) {
                    hasLeft = true;
                    break;
                }
            }
            if (!hasLeft)
                break;
            boolean[] signs = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (verges[i] == 1 && !signs[i]) {
                    for (int j = 0; j < edges.length; j++) {
                        if (edges[j][0] == i || edges[j][1] == i) {
                            verges[edges[j][0]]--;
                            verges[edges[j][1]]--;
                            signs[edges[j][0]] = true;
                            signs[edges[j][1]] = true;
                            edges[j][0] = -1;
                            edges[j][1] = -1;

                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++)
            if (verges[i] == 1)
                res.add(i);
        return res;
    }

    public static void main(String[] av) {
        int[][] test = new int[][]{{1, 0}, {1, 2}, {1, 3}};
        System.out.println(new MinimumHeightTrees().findMinHeightTrees(4, test));
    }
}
