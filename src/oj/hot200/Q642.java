package oj.hot200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q642 {
    public static void main(String[] args) {
        AutocompleteSystem autocompleteSystem = new AutocompleteSystem(new String[]{"i love you", "island", "iroman", "i love leetcode"},
                new int[]{5, 3, 2, 2});
        System.out.println(autocompleteSystem.root);
        System.out.println(autocompleteSystem.input('i'));
        System.out.println(autocompleteSystem.input(' '));
        System.out.println(autocompleteSystem.input('a'));
        System.out.println(autocompleteSystem.input('#'));

        System.out.println(autocompleteSystem.input('i'));
        System.out.println(autocompleteSystem.input(' '));
        System.out.println(autocompleteSystem.input('a'));
        System.out.println(autocompleteSystem.input('#'));
        System.out.println(autocompleteSystem.input('i'));
        System.out.println(autocompleteSystem.input(' '));
        System.out.println(autocompleteSystem.input('a'));
        System.out.println(autocompleteSystem.input('#'));
    }
}

class AutocompleteSystem {
    StringBuffer buffer = new StringBuffer();
    AccountNode root = new AccountNode(' ');
    AccountNode tmp = root;
    List<String> tmpList = new ArrayList<>();

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i], root, 0);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            insert(buffer.toString(), 1, root, 0);
            buffer = new StringBuffer();
            tmp = root;

        } else {
            buffer.append(c);
            tmpList = new ArrayList<>();
            if (tmp.children.containsKey(c)) {
                tmp = tmp.children.get(c);
                if (tmp.sentenceMap.size() <= 3) {
                    tmpList.addAll(tmp.sentenceMap.keySet());
                } else {
                    find(tmpList, tmp.sentenceMap);
                }

            }
        }
        return tmpList;
    }

    void find(List<String> res, Map<String, Integer> map) {
        int max = 0;
        String tmp = null;
        for (int i = 0; i < 3; i++) {
            for (String s : map.keySet()) {
                if (res.contains(s)) continue;
                if (tmp == null) {
                    tmp = s;
                    max = map.get(s);
                } else if (map.get(s) >= max) {
                    if (map.get(s) > max) {
                        tmp = s;
                        max = map.get(s);
                    } else {
                        if (s.compareTo(tmp) < 0) {
                            tmp = s;
                        }
                    }
                }
            }
            res.add(tmp);
            tmp = null;
        }

    }

    public void insert(String s, int time, AccountNode node, int i) {
        node.sentenceMap.put(s, node.sentenceMap.getOrDefault(s, 0) + time);
        if (s.length() <= i) return;
        char c = s.charAt(i);
        AccountNode child = node.children.getOrDefault(c, new AccountNode(c));
        node.children.put(c, child);
        insert(s, time, child, i + 1);
    }
}

 class AccountNode {
    char c;
    Map<Character, AccountNode> children;
    Map<String, Integer> sentenceMap;

    public AccountNode(char c) {
        this.c = c;
        children = new HashMap<>();
        sentenceMap = new HashMap<>();
    }


}