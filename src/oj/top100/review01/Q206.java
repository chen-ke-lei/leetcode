package oj.top100.review01;

import oj.dto.ListNode;

public class Q206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head, next = head.next, tmp;
        pre.next = null;
        while (next != null) {
            tmp = next.next;
            next.next = pre;
            pre = next;
            next = tmp;
        }
        return pre;
    }
}
