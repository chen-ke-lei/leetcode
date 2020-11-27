package oj.interview_tips;

import oj.dto.ListNode;

public class Q02_05 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int bit = 0;
        ListNode res = new ListNode(-1), pointer = res;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                int tmp = l1.val + l2.val + bit;
                bit = tmp / 10;
                tmp %= 10;
                l1 = l1.next;
                l2 = l2.next;
                pointer.next = new ListNode(tmp);
                pointer = pointer.next;
            } else {
                l1 = l2 == null ? l1 : l2;
                l2 = null;
                if (bit == 0) {
                    pointer.next = l1;
                    break;
                }
                int tmp = l1.val + bit;
                bit = tmp / 10;
                tmp %= 10;
                l1 = l1.next;
                pointer.next = new ListNode(tmp);
                pointer = pointer.next;
            }
        }
        if (bit != 0) pointer.next = new ListNode(bit);
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        new Q02_05().addTwoNumbers(l1, l2);
    }
}
