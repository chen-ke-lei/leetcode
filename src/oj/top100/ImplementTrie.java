package oj.top100;

import java.util.HashMap;
import java.util.Map;

public class ImplementTrie {
}

class Trie {
    Map<Character, Node> root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new HashMap<>();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Map<Character, Node> tmp = root;
        Node node = null;
        for (char c : word.toCharArray()) {
            if (!tmp.containsKey(c)) {
                tmp.put(c, new Node());
            }
            node = tmp.get(c);
            tmp = node.child;
        }
        node.end = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Map<Character, Node> tmp = root;
        Node node = null;
        for (char c : word.toCharArray()) {
            if (!tmp.containsKey(c))
                return false;
            node = tmp.get(c);
            tmp = tmp.get(c).child;
        }
        if (node != null && node.end)
            return true;
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Map<Character, Node> tmp = root;
        for (char c : prefix.toCharArray()) {
            if (!tmp.containsKey(c))
                return false;
            tmp = tmp.get(c).child;
        }
        return true;

    }

    class Node {
        Map<Character, Node> child;
        boolean end;

        public Node() {
            child = new HashMap<>();
            end = false;
        }

    }
}

