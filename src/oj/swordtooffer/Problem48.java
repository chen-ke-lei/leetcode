package oj.swordtooffer;

import java.util.HashMap;
import java.util.Map;

public class Problem48 {
    public static void main(String[] av){
        System.out.println(new Problem48().lengthOfLongestSubstring("abba"));
    }
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int begin = 0;
        int res = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                begin = begin<map.get(c)+1?map.get(c)+1:begin;
            }
            map.put(c, i);
            System.out.println(c+"  "+begin);
            res = res > i - begin+1 ? res : i - begin+1;
        }
        return res;
    }
}
