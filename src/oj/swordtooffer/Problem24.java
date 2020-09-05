package oj.swordtooffer;

import oj.dto.ListNode;

public class Problem24 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = head, next = head.next, tmp = null;
        head.next = null;
        while (next != null) {
            tmp = next;
            next = next.next;
            tmp.next = pre;
            pre = tmp;

        }
        return tmp;
    }
}
