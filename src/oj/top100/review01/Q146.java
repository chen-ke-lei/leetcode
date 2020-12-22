package oj.top100.review01;

import java.util.HashMap;

public class Q146 {
    static class LRUCache {
        HashMap<Integer, Node> lru;
        Node head;
        Node tail;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            lru = new HashMap<>();
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (!lru.containsKey(key)) return -1;
            move2Head(lru.get(key));
            return lru.get(key).val;
        }

        public void put(int key, int value) {
            if (this.capacity == 0) return;
            if (lru.containsKey(key)) {
                remove(lru.get(key));
            } else {
                if (lru.size() == this.capacity) {
                    remove(tail.pre);
                }
            }
            Node node = new Node(key, value);
            lru.put(key, node);
            Node tmp = head.next;
            node.next = tmp;
            head.next = node;
            node.pre = head;
            tmp.pre = node;
        }

        void move2Head(Node node) {
            if (head.next == node) return;
            node.pre.next = node.next;
            node.next.pre = node.pre;
            Node tmp = head.next;
            node.next = tmp;
            head.next = node;
            node.pre = head;
            tmp.pre = node;
        }

        void remove(Node node) {
            lru.remove(node.k);
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public static void main(String[] args) {
            LRUCache lruCache = new LRUCache(2);
            System.out.println(lruCache.head);
            lruCache.put(1, 1);
            System.out.println(lruCache.head);
            lruCache.put(2, 2);
            System.out.println(lruCache.head);
            lruCache.get(1);
            System.out.println(lruCache.head);
            lruCache.put(3, 3);
            System.out.println(lruCache.head);
            lruCache.get(2);
            System.out.println(lruCache.head);
        }
    }

    static class Node {
        int k;
        int val;
        Node pre;
        Node next;

        @Override
        public String toString() {
            return val + "-->" + next;
        }

        public Node(int k, int v) {
            this.k = k;
            val = v;
        }
    }
}
