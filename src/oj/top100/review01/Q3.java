package oj.top100.review01;

import java.util.HashMap;
import java.util.Map;

public class Q3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int res = 1;
        map.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= start) {
                start = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i), i);
            res = res > i - start+1 ? res : i - start+1;
        }

        return res;
    }
}
