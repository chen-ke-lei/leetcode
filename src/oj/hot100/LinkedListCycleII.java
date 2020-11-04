package oj.hot100;

import oj.dto.ListNode;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (true) {
            if (fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
