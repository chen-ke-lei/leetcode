package oj.hot200;

import java.util.HashMap;
import java.util.Map;

public class Q340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() == 0 || k == 0) return 0;
        int max = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 1);
        int start = 0, i = 1;
        while (i < s.length()) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if (map.size() <= k) {
                max = max > i - start + 1 ? max : i - start + 1;
            } else {
                while (map.size() > k) {
                    map.put(s.charAt(start), map.get(s.charAt(start) )-1);
                    if (map.get(s.charAt(start)) == 0)
                        map.remove(s.charAt(start));
                    start++;
                }
            }
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Q340().lengthOfLongestSubstringKDistinct("aba",1));
    }
}
