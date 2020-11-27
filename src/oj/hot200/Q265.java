package oj.hot200;

import java.util.ArrayList;
import java.util.List;

public class Q265 {
    public int minCostII(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) return 0;
        if(costs[0].length==1)return costs[0][0];
        int[][] dp = new int[costs.length][costs[0].length];
        dp[0] = costs[0];
        for (int i = 1; i < costs.length; i++) {
            List<Integer> tmpMin = findMin(dp[i - 1]);
            for (int j = 0; j < costs[i].length; j++) {
                if (j != tmpMin.get(0)) {
                    dp[i][j] = costs[i][j] + dp[i-1][tmpMin.get(0)];
                } else {
                    dp[i][j] = costs[i][j] + dp[i-1][tmpMin.get(1)];
                }
            }
        }
        return dp[dp.length - 1][findMin(dp[dp.length - 1]).get(0)];
    }

    List<Integer> findMin(int[] arr) {
        int min = Math.min(arr[0], arr[1]);
        int minIndex = arr[0] == min ? 0 : 1;
        int mid = minIndex == 0 ? arr[1] : arr[0];
        int midIndex = minIndex == 0 ? 1 : 0;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > mid) continue;
            if (arr[i] <= min) {
                mid = min;
                midIndex = minIndex;
                min = arr[i];
                minIndex = i;
            } else {
                mid = arr[i];
                midIndex = i;
            }
        }
        List<Integer> integers = new ArrayList<>();
        integers.add(minIndex);
        integers.add(midIndex);
        return integers;
    }
}
