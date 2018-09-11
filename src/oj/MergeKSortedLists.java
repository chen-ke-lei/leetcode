package oj;

import oj.dto.ListNode;

public class MergeKSortedLists {
	 public ListNode mergeKLists(ListNode[] lists) {
	        ListNode res=new ListNode(Integer.MIN_VALUE),tmp=res;
	        while(true) {
	        	int index=-1;
	        	int maxVal=Integer.MAX_VALUE;
	        	for(int i=0;i<lists.length;i++) {
	        		if(lists[i]==null)
	        			continue;
	        		if(lists[i].val<=maxVal) {
	        			maxVal=lists[i].val;
	        			index=i;
	        		}
	        	}
	        	if(index==-1)
	        		break;
	        	tmp.next=lists[index];
	        	lists[index]=lists[index].next;
	        	tmp=tmp.next;
	        }       
	        return res.next;
	    }
}
