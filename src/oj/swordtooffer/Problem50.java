package oj.swordtooffer;

import java.util.HashMap;
import java.util.Map;

public class Problem50 {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < s.length(); i++)
            if (map.get(s.charAt(i)) == 1)
                return s.charAt(i);
        return ' ';
    }
}
