package oj.hot100;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int beg = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= beg)
                beg = map.get(c) + 1;

            res = res > i - beg + 1 ? res : i - map.get(c);

            map.put(c, i);

        }
        return res;
    }
}
