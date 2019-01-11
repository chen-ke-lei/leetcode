package oj;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	int capacity;
	int size;
	LinkedNode head;
	LinkedNode tail;
	Map<Integer, LinkedNode> valMap;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		size = 0;
		valMap = new HashMap<>();
		head = null;
		tail = null;
	}

	public int get(int key) {	
		if (valMap.containsKey(key)) {
			LinkedNode node = valMap.get(key);
			if (node == head) {
				return node.val;
			}
			if (node == tail) {
				tail = node.pre;
				tail.next = null;
			} else {
				node.pre.next = node.next;
				node.next.pre=node.pre;
			}
			setHead(node);
			return node.val;
		}
		return -1;
	}
	
	public void setHead(LinkedNode node ) {
		head.pre = node;
		node.next = head;
		head = node;
		head.pre = null;
	}
	public void put(int key, int value) {
		LinkedNode node = new LinkedNode(value, key);
		if (size == 0) {
			valMap.put(key, node);
			head = node;
			tail = node;
			size++;
		} else if (valMap.containsKey(key)) {
			node = valMap.get(key);
			node.val = value;
			get(key);
		} else if (size < capacity && !valMap.containsKey(key)) {
			valMap.put(key, node);
			node.next = head;
			head.pre = node;
			head = node;
			size++;
		} else if (size == capacity && !valMap.containsKey(key)) {

			valMap.remove(tail.key);
			tail = tail.pre;
			size--;
			put(key, value);
		}
	}

	class LinkedNode {
		int val;
		int key;

		public LinkedNode(int val, int key) {
			this.val = val;
			this.key = key;
		}

		LinkedNode next;
		LinkedNode pre;
	}
}
