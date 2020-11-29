package oj.hot200;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q1055 {
    public int shortestWay(String source, String target) {
        Set<String> subString = new HashSet<>();
        dfs(source, subString);
        subString.add(source);
        int[] dp = new int[target.length() + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= target.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] >= 0 && subString.contains(target.substring(j , i))) {
                    if (dp[i] < 0) {
                        dp[i] = dp[j] + 1;
                    } else {
                        dp[i] = dp[i] > dp[j] + 1 ? dp[j] + 1 : dp[i];
                    }
                }
            }
        }
        return dp[target.length()];
    }

    void dfs(String source, Set<String> subString) {
        if (source.length() == 0) return;
        for (int i = 0; i < source.length(); i++) {
            String tmp = source.substring(0, i) + source.substring(i + 1);
            if (subString.contains(tmp)) continue;
            subString.add(tmp);
            dfs(tmp, subString);
        }
    }
}
