package oj.top100.review01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int num = p.length();
        Map<Character, Integer> ori = new HashMap<>(), tar = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            ori.put(p.charAt(i), ori.getOrDefault(p.charAt(i), 0) + 1);
        }
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!ori.containsKey(c)) {
                start = i + 1;
                tar.clear();
            } else {
                if (tar.getOrDefault(c, 0) < ori.get(c)) {
                    tar.put(c, tar.getOrDefault(c, 0) + 1);
                    if (i - start + 1 == num) {
                        res.add(start);
                        tar.put(s.charAt(start), tar.get(s.charAt(start)) - 1);
                        start++;

                    }
                } else {
                    while (s.charAt(start) != c) {
                        tar.put(s.charAt(start), tar.get(s.charAt(start)) - 1);
                        start++;
                    }
                    tar.put(s.charAt(start), tar.get(s.charAt(start)) - 1);
                    start++;
                    tar.put(c, tar.getOrDefault(c, 0) + 1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q438().findAnagrams("abaacbabc", "abc"));
    }
}
