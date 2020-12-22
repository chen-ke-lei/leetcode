package oj.top100.review01;

import java.util.HashMap;
import java.util.Map;

public class Q208 {
    class Trie {
        Node head;
        /**
         * Initialize your data structure here.
         */
        public Trie() {
            head = new Node('\0');
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Node node = head;
            for (int i = 0; i < word.length(); i++) {
                if (!node.nodeMap.containsKey(word.charAt(i))) {
                    node.nodeMap.put(word.charAt(i), new Node(word.charAt(i)));
                }
                node = node.nodeMap.get(word.charAt(i));
            }
            node.end = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Node node = findNode(word);
            if (node == null || !node.end) return false;
            return true;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Node node = findNode(prefix);
            if (node == null) return false;
            return true;
        }

        Node findNode(String word) {
            Node node = head;
            for (int i = 0; i < word.length(); i++) {
                if (!node.nodeMap.containsKey(word.charAt(i))) return null;
                node = node.nodeMap.get(word.charAt(i));
            }
            return node;
        }
    }

    class Node {
        boolean end;
        char c;
        Map<Character, Node> nodeMap = new HashMap<>();

        public Node(char c) {
            this.c = c;
        }
    }
}
