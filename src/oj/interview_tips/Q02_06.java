package oj.interview_tips;

import oj.dto.ListNode;

public class Q02_06 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head, slow = head, pre = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;

        }
        pre.next = null;
        ListNode tmp = slow;
        pre = slow.next;
        while (pre != null) {
   //         slow.next = null;

            tmp = pre.next;
            pre.next = slow;

            slow = pre;
            pre = tmp;
        }
        while (head != null && slow != null) {
            if (head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.create(new int[]{1, 0, 3, 4, 0, 1});
        new Q02_06().isPalindrome(node);
    }
}
