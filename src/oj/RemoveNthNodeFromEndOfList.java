package oj;

import oj.dto.ListNode;

public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode parent=null,fast=head,now=head;
		for(int i=0;i<n&&fast!=null;i++) 
			fast=fast.next;
		if(fast==null)
			return head.next;
		while(fast!=null) {
			fast=fast.next;
			parent=now;
			now=now.next;
		}
		parent.next=now.next;
		
		return head;
	}
}
