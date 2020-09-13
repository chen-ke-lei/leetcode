package oj.hot100;

import oj.dto.ListNode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)
            return true;
        ListNode slow=head,fast=head.next;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode pre=null,next=slow.next,tmp;
        slow.next=null;
        while (next!=null){
            tmp=next.next;
            next.next=pre;
            pre=next;
            next=tmp;
        }
        while (pre!=null){
            if(pre.val!=head.val)
                return false;
            pre=pre.next;
            head=head.next;
        }
        return true;
    }
}
