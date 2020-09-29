package oj.hot100;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int length;
    int capacity;
    Node head;
    Node tail;
    Map<Integer, Node> kv;

    public LRUCache(int capacity) {
        head = null;
        this.capacity = capacity;
        length = 0;
        tail = null;
        kv = new HashMap<>();
    }

    public int get(int key) {
        if (!kv.containsKey(key))
            return -1;
        Node node = kv.get(key);
        move(node);
        return node.v;
    }

    public void put(int key, int value) {
        if (kv.containsKey(key)) {
            kv.get(key).v = value;
            move(kv.get(key));
        } else {
            Node node = new Node();
            node.k = key;
            node.v = value;
            kv.put(node.k,node);
            if (length == 0) {
                head = tail = node;
                length++;
            } else if (length < capacity) {
                length++;
                head.pre = node;
                node.next = head;
                head = node;
            } else {
                kv.remove(tail.k);
                tail = tail.pre;
                tail.next.pre = null;
                tail.next = null;
                head.pre = node;
                node.next = head;
                head = node;
            }
        }


    }

    void move(Node node) {
        if (node == head)
            return;
        if (node == tail) {
            tail = node.pre;
            tail.next = null;
            node.pre = null;
            node.next = head;
            head.pre = node;
            head = node;
        } else {
            Node next = node.next, pre = node.pre;
            next.pre = pre;
            pre.next = next;
            node.pre = null;
            node.next = head;
            head.pre = node;
            head = node;
        }


    }

    class Node {
        int k;
        int v;
        Node next;
        Node pre;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
//        lruCache.put(1, 1);
//        lruCache.put(2, 2);
//        lruCache.get(1);
//        lruCache.put(3, 3);
//        lruCache.get(2);
//        lruCache.put(4, 4);
//        lruCache.get(1);
//        lruCache.get(3);
//        lruCache.get(4);
    }
}
