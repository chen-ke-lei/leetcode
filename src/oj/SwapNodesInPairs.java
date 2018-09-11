package oj;

import oj.dto.ListNode;

public class SwapNodesInPairs {
	 public ListNode swapPairs(ListNode head) {
	        ListNode res=new ListNode(0),parent=res,now=head ,tmp=null;
	        res.next=head;
	         while(now!=null&&now.next!=null) {
	        	 tmp=now.next;
	        	 now.next=tmp.next;
	        	 tmp.next=now;
	        	 parent.next=tmp;
	        	 parent=now;
	        	 now=now.next;
	         }
	        return res.next;
	    }
}
