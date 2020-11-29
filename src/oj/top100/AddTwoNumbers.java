package oj.top100;

import oj.dto.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        int bit = 0;
        ListNode res = new ListNode(-1);
        ListNode point = res;
        while (l1 != null && l2 != null) {
            int tmp = l1.val + l2.val + bit;
            bit = tmp / 10;
            tmp %= 10;
            point.next = new ListNode(tmp);
            point = point.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null || l2 != null || bit > 0) {
            if (l2 != null) l1 = l2;
            while (l1 != null && bit > 0) {
                int tmp = l1.val + bit;
                bit = tmp / 10;
                tmp %= 10;
                point.next = new ListNode(tmp);
                point = point.next;
                l1 = l1.next;
            }
            if (l1 != null) {
                point.next = l1;
            } else if (bit > 0) {
                point.next = new ListNode(bit);
            }
        }

        return res.next;
    }
}
