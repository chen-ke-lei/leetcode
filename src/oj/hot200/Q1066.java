package oj.hot200;

public class Q1066 {
    int min = Integer.MAX_VALUE;

    public int assignBikes(int[][] workers, int[][] bikes) {

        int[][] tmp = new int[workers.length][bikes.length];
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                tmp[i][j] = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
            }
        }
        for (int i = 0; i < tmp[0].length; i++) {
            boolean[] vis = new boolean[tmp[0].length];
            vis[i] = true;
            visit(tmp, 1, tmp[0][i], vis);
        }
        return min;
    }

    void visit(int[][] tmp, int i, int sub, boolean[] vis) {
        if (i == tmp.length) {
            min = min < sub ? min : sub;
            return;
        }
        for (int j = 0; j < vis.length; j++) {
            if (vis[j]) continue;
            vis[j] = true;
            visit(tmp, i + 1, sub + tmp[i][j], vis);
            vis[j]=false;
        }
    }
}
