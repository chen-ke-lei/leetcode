package oj;

import oj.dto.ListNode;

public class MiddleOfTheLinkedList {
	 public ListNode middleNode(ListNode head) {
	        ListNode slow=head,fast=head;
	        while(fast!=null&&fast.next!=null) {
	        	fast=fast.next.next;
	        	slow=slow.next;
	        }
	        return slow;
	    }
}
