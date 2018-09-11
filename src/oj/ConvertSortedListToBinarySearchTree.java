package oj;

import oj.dto.*;

public class ConvertSortedListToBinarySearchTree {
	 public TreeNode sortedListToBST(ListNode head) {
	        return dfs(head);
	    }
	 
	 TreeNode  dfs (ListNode head) {
		 if(head==null)
			 return null;
		 ListNode solw=head,fast=head,tmp=null;
		 while(fast!=null && fast.next!=null) {
			 fast=fast.next.next;
			 tmp=solw;
			 solw=solw.next;
		 }
		 TreeNode res=new TreeNode(solw.val);
		 if(tmp!=null)
		 tmp.next=null;
		 res.left=dfs(head);
		 res.right=dfs(solw.next);
		 return res;
	 }
}
