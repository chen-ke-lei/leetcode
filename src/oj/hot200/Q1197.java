package oj.hot200;

import java.util.HashSet;
import java.util.Set;

public class Q1197 {
    public int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) return 0;
        int res = 0;
        int[] step = new int[]{-2, -1, 1, 2};
        Set<String> all = new HashSet<>(), pre = new HashSet<>(), next = new HashSet<>();
        pre.add("0,0");
        all.add("0,0");
        while (!pre.isEmpty()) {
            res++;
            for (String s : pre) {
                int x_tmp = new Integer(s.split(",")[0]);
                int y_tmp = new Integer(s.split(",")[1]);
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (Math.abs(step[i]) == Math.abs(step[j])) continue;
                        if (x_tmp + step[i] == x && y_tmp + step[j] == y) return res;
                        if (Math.abs(x_tmp + step[i] - x) > Math.abs(x) || Math.abs(y_tmp + step[j] - y) > Math.abs(y))
                            continue;
                        String tmp = (x_tmp + step[i]) + "," + (y_tmp + step[j]);
                        if (!all.contains(tmp)) {
                            next.add(tmp);
                        }
                    }
                }
            }
            all.addAll(next);
            pre = next;
            next = new HashSet<>();

        }
        return res;
    }
}
