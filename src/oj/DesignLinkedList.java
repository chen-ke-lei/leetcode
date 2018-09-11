package oj;



public class DesignLinkedList {
	public static void main(String[] args) {
		MyLinkedList myLinkedList = new MyLinkedList();
		show(myLinkedList);
		myLinkedList.addAtHead(1);
		show(myLinkedList);
		myLinkedList.addAtTail(3);
		show(myLinkedList);
		myLinkedList.addAtIndex(1, 2);
		show(myLinkedList);
		myLinkedList.get(1);
		show(myLinkedList);
		myLinkedList.deleteAtIndex(1);
		show(myLinkedList);
		myLinkedList.get(1);
		show(myLinkedList);
	}
	static void show(MyLinkedList linkedList) {
		MyLinkedList.ListNode point=linkedList.head;
		String resString="show:";
		while(point!=null) {
			resString+=point.val+"->";
			point=point.next;
		}
		System.out.println(resString);
	}
}

class MyLinkedList {
	int length;
	ListNode head;

	/** Initialize your data structure here. */
	public MyLinkedList() {
		length = 0;
		head = null;
	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public int get(int index) { 
		if (index < 0 || index >= length)
			return -1;
		ListNode tmp = head;
		for (int i = 1; i <= index; i++)
			tmp = tmp.next;
		return tmp.val;
	}

	/**
	 * Add a node of value val before the first element of the linked list. After
	 * the insertion, the new node will be the first node of the linked list.
	 */
	public void addAtHead(int val) {
		ListNode listNode = new ListNode(val);
		listNode.next = head;
		head = listNode;
		length++;
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		addAtIndex( length,val);
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index
	 * equals to the length of linked list, the node will be appended to the end of
	 * linked list. If index is greater than the length, the node will not be
	 * inserted.
	 */
	public void addAtIndex(int index, int val) {
		if (index > length)
			return;
		if (index == 0) {
			addAtHead(val);
			return;
		}
		length++;
		ListNode tmp = head;
		for (int i = 1; i < index; i++) {
			tmp = tmp.next;
		}
		ListNode next = tmp.next;
		ListNode res = new ListNode(val);
		tmp.next = res;
		res.next = next;
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		if (index < 0 || index >= length)
			return;
		length--;
		if (index == 0) {
			head = head.next;
			return;
		}
		ListNode tmp = head;
		for (int i = 1; i < index; i++)
			tmp = tmp.next;
		tmp.next = tmp.next.next;
	}

	static class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int x) {
			val = x;
		}
	}
}
