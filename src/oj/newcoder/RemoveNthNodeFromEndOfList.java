package oj.newcoder;

import oj.dto.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre=new ListNode(1);
        pre.next=head;
        ListNode fast = pre, slow = pre;
        for (int i = 0; i < n; i++)
            fast = fast.next;
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return pre.next;
    }
}
