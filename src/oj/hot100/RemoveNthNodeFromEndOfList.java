package oj.hot100;

import oj.dto.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head, pre = head;
        for (int i = 0; i < n; i++)
            fast = fast.next;
        if (fast == null)
            return head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = slow.next;
        slow.next = null;
        return head;
    }
}
