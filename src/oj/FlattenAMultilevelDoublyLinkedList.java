package oj;

import oj.dto.Node;

public class FlattenAMultilevelDoublyLinkedList {
	 public Node flatten(Node head) {
		 dfs(head);
		 return head;
		
	    }
	 
	 Node dfs(Node head) {
		 if(head==null||(head.next==null&&head.child==null))
			 return head;
		 while(head!=null) {
			 if(head.next!=null) {
				 if(head.child==null) {
					 head=head.next;
					 continue;
				 }
				 Node tmp=head.next;
				 dfs(head.child).next=tmp;
				 head.child=null;
				head=tmp;
			 }else {
				if(head.child!=null) {
					head.next=head.child;
					head.child=null;
				}
				
			}		
		 }
		 return head;
	 }
}
