package oj.hot200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q291 {
    public boolean wordPatternMatch(String pattern, String s) {
        if (s.length() < pattern.length()) return false;
        int[] numbers = new int[26];
        for (char c : pattern.toCharArray()) {
            numbers[c - 'a']++;
        }
        List<List<Integer>> tmp = new ArrayList<>();
        dfs(tmp, new ArrayList<>(), numbers, 0, s.length());
        for (List<Integer> list : tmp) {
            int i = 0, j = 0;
            Map<Character, String> p2S = new HashMap<>();
            Map<String, Character> s2P = new HashMap<>();
            boolean res = true;
            while (i < s.length() && j < pattern.length()) {
                char c = pattern.charAt(j);
                int len = list.get(c - 'a');
                if (i + len > s.length()) {
                    res = false;
                    break;
                }
                String sub = s.substring(i, i + len);
                if (p2S.containsKey(c) && !sub.equals(p2S.get(c))) {
                    res = false;
                    break;
                }
                if (s2P.containsKey(sub) && s2P.get(sub) != c) {
                    res = false;
                    break;
                }
                p2S.put(c, sub);
                s2P.put(sub, c);
                i = i + len;
                j++;
            }
            if (res) return true;
        }
        return false;
    }

    void dfs(List<List<Integer>> res, List<Integer> tmp, int[] sub, int i, int count) {
        if (i == 26) {
            if (count == 0)
                res.add(new ArrayList<>(tmp));
            return;
        }
        if (count < sub[i]) return;

        if (sub[i] == 0) {
            tmp.add(0);
            dfs(res, tmp, sub, i + 1, count);
            tmp.remove(tmp.size() - 1);
            return;
        }
        for (int j = 1; sub[i] * j <= count; j++) {
            tmp.add( j);
            dfs(res, tmp, sub, i + 1, count - sub[i] * j);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q291().wordPatternMatch("aba"
                , "aaaa"));
    }
}
