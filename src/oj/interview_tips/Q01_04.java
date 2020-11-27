package oj.interview_tips;

import java.util.HashMap;
import java.util.Map;

public class Q01_04 {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        for (Integer value : map.values()) {
            if (value % 2 != 0) res++;
        }

        return res <= 1;
    }
}
