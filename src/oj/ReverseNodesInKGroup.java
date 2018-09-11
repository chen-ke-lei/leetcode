package oj;

import oj.dto.ListNode;

public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (k <= 1)
			return head;
		ListNode res = new ListNode(0),reverseHead=head,reverseTail=null,parent=res,tmp=null;
		while(reverseHead!=null) {
			tmp=reverseHead.next;
			for(int i=0;i<k;i++) {
				if(tmp==null) {
					
				}else {
					reverseHead.next=null;
				}
			}
		}
		return res.next;
	}
}
