package oj.interview_tips;

import oj.dto.ListNode;

public class Q02_04 {
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null)return head;
        ListNode headNode = new ListNode(-1), tail = head;
        headNode.next = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        ListNode tailNoe = tail, pre = headNode;
        while (pre.next != tail) {
            if (pre.next.val < x) {
                pre = pre.next;
            } else {
                tailNoe.next= pre.next;
                tailNoe = tailNoe.next;
                pre.next = pre.next.next;
                tailNoe.next=null;
            }
        }

        return headNode.next;
    }
}
