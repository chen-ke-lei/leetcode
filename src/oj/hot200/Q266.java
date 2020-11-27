package oj.hot200;

import java.util.HashMap;
import java.util.Map;

public class Q266 {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> c2I = new HashMap<>();
        int one = 0;
        for (char c : s.toCharArray()) {
            c2I.put(c, c2I.getOrDefault(c, 0) + 1);

            if (c2I.get(c) % 2 == 1) one++;
            else if (c2I.get(c) % 2 == 0) one--;
        }
        return s.length() % 2 == one;
    }
}
