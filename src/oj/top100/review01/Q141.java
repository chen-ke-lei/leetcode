package oj.top100.review01;

import oj.dto.ListNode;

public class Q141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            head = head.next;
            if (head == fast) return true;
        }
        return false;
    }
}
