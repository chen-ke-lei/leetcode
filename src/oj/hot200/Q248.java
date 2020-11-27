package oj.hot200;

import java.util.HashMap;
import java.util.Map;

public class Q248 {
    public int strobogrammaticInRange(String low, String high) {
        Map<Character, Integer> times = new HashMap<>();
        times.put('1', 1);
        times.put('5', 2);
        if (high.length() == 1) {

        }
        int[] dp = new int[high.length()];
        return dp[0];
    }
}
