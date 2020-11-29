package oj.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, List<Node>> map = new HashMap<>();
        Node head = new Node();
        Node tail = new Node();
        head.next = tail;
        tail.pre = head;

        String res = null;
        Map<Character, Integer> mapIndex = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            mapIndex.put(t.charAt(i), mapIndex.getOrDefault(t.charAt(i), 0) + 1);

        int type = t.length();
        for (int i = 0; i < s.length(); i++) {
            if (!mapIndex.containsKey(s.charAt(i))) continue;
            if (mapIndex.get(s.charAt(i)) > 0) {
                Node node = new Node();
                node.index = i;
                Node tmp = tail.pre;
                tmp.next = node;
                node.pre = tmp;
                tail.pre = node;
                node.next = tail;
                type--;
                mapIndex.put(s.charAt(i), mapIndex.get(s.charAt(i)) - 1);
                if (!map.containsKey(s.charAt(i))) map.put(s.charAt(i), new ArrayList<>());
                map.get(s.charAt(i)).add(node);
            } else {
                Node node = map.get(s.charAt(i)).get(0);
                map.get(s.charAt(i)).remove(0);
                node.pre.next = node.next;
                node.next.pre = node.pre;
                node = new Node();
                node.index = i;
                Node tmp = tail.pre;
                tmp.next = node;
                node.pre = tmp;
                tail.pre = node;
                node.next = tail;
                map.get(s.charAt(i)).add(node);
            }
            if (type == 0) {
                if (res == null) res = s.substring(head.next.index, tail.pre.index + 1);
                else {
                    res = res.length() < s.substring(head.next.index, tail.pre.index + 1).length() ?
                            res : s.substring(head.next.index, tail.pre.index + 1);
                }
            }
        }

        return res == null ? "" : res;
    }


}

class Node {
    int index;
    Node pre;
    Node next;
}
