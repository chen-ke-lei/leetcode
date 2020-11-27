package oj.hot200;

import java.util.HashMap;
import java.util.Map;

public class Q1165 {
    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < keyboard.length(); i++) {
            map.put(keyboard.charAt(i), i);
        }
        int res = 0;
        int last=0;
        for (int i = 0; i < word.length(); i++) {
            res += Math.abs(map.get(word.charAt(i)) - last);
            last=map.get(word.charAt(i));
        }
        return res;
    }
}
