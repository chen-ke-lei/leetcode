package oj.newcoder;

import oj.dto.ListNode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null)
            return head;
        ListNode pre = new ListNode(-1), fixPre = pre;
        ListNode next = new ListNode(-1), fixNext = next;
        while (head != null) {
            if (head.val < x) {
                pre.next = head;
                pre = head;
            } else {
                next.next = head;
                next = head;
            }
            head = head.next;

        }
        pre.next = fixNext.next;
        //注意，不然会有死循环
        next.next=null;
        return fixPre.next;
    }
}
