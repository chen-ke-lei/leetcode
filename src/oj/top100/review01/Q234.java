package oj.top100.review01;

import oj.dto.ListNode;

public class Q234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null) {
            pre.next = null;
        } else {
            slow = slow.next;
            pre = pre.next;
            pre.next = null;
        }
        pre = slow;
        fast = slow.next;
        slow.next = null;
        while (fast != null) {
            pre = fast.next;
            fast.next = slow;
            slow = fast;
            fast = pre;
        }
        while (slow != null) {
            if (slow.val != head.val) return false;
            slow = slow.next;
            head = head.next;
        }

        return true;
    }
}
