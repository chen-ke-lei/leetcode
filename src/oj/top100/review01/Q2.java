package oj.top100.review01;

import oj.dto.ListNode;

public class Q2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1), node = res;
        int bit = 0;
        while (l1 != null || l2 != null) {
            int num = bit;
            if (l1 != null) {
                num += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num += l2.val;
                l2 = l2.next;
            }
            bit = num / 10;
            num %= 10;
            node.next = new ListNode(num);
            node=node.next;
        }
        if (bit == 1)
            node.next = new ListNode(1);
        return res.next;
    }
}
