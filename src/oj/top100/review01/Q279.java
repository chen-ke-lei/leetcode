package oj.top100.review01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q279 {
    public int numSquares(int n) {
        List<Integer> squuares = new ArrayList<>();
        int i = 1;
        while (i * i <= n) {
            squuares.add(i * i);
            i++;
        }
        if (squuares.get(squuares.size() - 1) == n) return 1;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (i = 1; i <= n; i++) {
            for (int k = 0; k < squuares.size(); k++) {
                int num = squuares.get(k);
                if (num > i) break;
                if (dp[i - num] >= 0) {
                    if (dp[i] == -1) dp[i] = dp[i - num] + 1;
                    else dp[i] = Math.min(dp[i], dp[i - num] + 1);
                }
            }
        }
        return dp[n];
    }
}
