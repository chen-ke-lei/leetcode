package oj.top100.review01;

import oj.dto.ListNode;

public class Q19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode fast = node, slow = node;
        for (int i = 0; i < n; i++)
            fast = fast.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return node.next;
    }
}
