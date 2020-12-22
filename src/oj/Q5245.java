package oj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q5245 {
    public int maxHeight(int[][] cuboids) {
        List<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < cuboids.length; i++) {
            int[] cuboid = cuboids[i];
            int[] sub1 = new int[4], sub2 = new int[4], sub3 = new int[4];
            sub1[3] = i;
            sub1[2] = cuboid[2];
            sub1[0] = Math.max(cuboid[0], cuboid[1]);
            sub1[1] = Math.min(cuboid[0], cuboid[1]);

            sub2[2] = cuboid[1];
            sub2[3] = i;
            sub2[0] = Math.max(cuboid[0], cuboid[2]);
            sub2[1] = Math.min(cuboid[0], cuboid[2]);

            sub3[2] = cuboid[0];
            sub3[3] = i;
            sub3[0] = Math.max(cuboid[1], cuboid[2]);
            sub3[1] = Math.min(cuboid[1], cuboid[2]);
            tmp.add(sub1);
            tmp.add(sub2);
            tmp.add(sub3);
        }
        tmp.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });
        Map<Integer, Integer>[] sets = new Map[tmp.size()];
        sets[0] = new HashMap<>();
        sets[0].put(tmp.get(0)[3], 0);
        int[] res = new int[tmp.size()];
        res[0] = tmp.get(0)[2];
        int max = res[0];
        for (int i = 1; i < tmp.size(); i++) {
            res[i] = tmp.get(i)[2];
            sets[i] = new HashMap<>();
            sets[i].put(tmp.get(i)[3], i);
            for (int j = 0; j < i; j++) {
                if (!comparge(tmp.get(j), tmp.get(i))) {
                    continue;
                }
                int sub = res[j] + tmp.get(i)[2];
                if (sets[j].containsKey(tmp.get(i)[3]))
                    sub -= tmp.get(sets[j].get(tmp.get(i)[3]))[2];
                if (sub > res[i]) {
                    res[i] = sub;
                    sets[i] = new HashMap<>(sets[j]);
                    sets[i].put(tmp.get(i)[3], i);
                }
            }
            max = Math.max(max, res[i]);
        }


        return max;
    }

    boolean comparge(int[] a1, int[] a2) {
        if (a1[0] <= a2[0] && a1[1] <= a2[1] && a1[2] <= a2[2]) return true;
        return false;
    }

    public static void main(String[] args) {
        int[][] test = {{7, 11, 17}, {7, 17, 11}, {11, 7, 17}, {11, 17, 7}, {17, 7, 11}, {17, 11, 7}};
        System.out.println(new Q5245().maxHeight(test));
    }
}
