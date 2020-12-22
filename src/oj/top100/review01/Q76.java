package oj.top100.review01;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Q76 {
    public String minWindow(String s, String t) {
        String res = "";
        LinkedList<Integer> list = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        int stack = t.length();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                list.addFirst(i);
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) >= 0) stack--;
                while (!list.isEmpty() && map.get(s.charAt(list.getLast())) < 0) {
                    map.put(s.charAt(list.getLast()), map.get(s.charAt(list.getLast())) + 1);
                    list.removeLast();
                }
                if (stack == 0 && (res.length() == 0 || (res.length() > 0 && list.getFirst() - list.getLast() + 1 < res.length()))) {
                    res = s.substring(list.getLast(), list.getFirst() + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q76().minWindow("ADOBECODEBANC","ABC"));
    }
}
