package oj.newcoder;

import oj.dto.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            if (fast.next.next == slow.next)
                return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
