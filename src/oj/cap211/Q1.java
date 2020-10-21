package oj.cap211;

import java.util.HashMap;
import java.util.Map;

public class Q1 {
    public int maxLengthBetweenEqualCharacters(String s) {
        if (s.length() <= 1) return -1;
        int res = -1;
        Map<Character, Integer> c2I = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!c2I.containsKey(s.charAt(i))) {
                c2I.put(s.charAt(i), i);
            }else {
                res=res>i-c2I.get(s.charAt(i))-1?res:i-c2I.get(s.charAt(i))-1;
            }
        }
        return res;
    }
}
