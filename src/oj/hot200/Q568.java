package oj.hot200;

import java.util.Arrays;

public class Q568 {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int[][] dp = new int[days[0].length + 1][flights.length];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
            dp[0][0] = 0;
        }
        for (int i = 0; i < dp.length - 1; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (dp[i][j] >= 0) {
                    int[] path = flights[j];
                    for (int i1 = 0; i1 < path.length; i1++) {
                        if (path[i1] == 1 || i1 == j) {
                            int tmp = days[i1][i] + dp[i][j];
                            if (dp[i + 1][i1] < tmp)
                                dp[i + 1][i1] = tmp;
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp[dp.length - 1].length; i++) {
            res = res > dp[dp.length - 1][i] ? res : dp[dp.length - 1][i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q568().maxVacationDays(
                new int[][]{{0, 1, 0}, {0, 0, 0}, {0, 0, 0}}, new int[][]
                        {{0, 0, 7}, {2, 0, 0}, {7, 7, 7}}
        ));
    }
}
