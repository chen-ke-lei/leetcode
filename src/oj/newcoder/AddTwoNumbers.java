package oj.newcoder;

import oj.dto.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1), pointer = res;
        int bit = 0, a = 0, b = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }

            int tmp = bit + a + b;
            bit = 0;
            if (tmp >= 10) {
                bit = 1;
                tmp -= 10;
            }
            pointer.next = new ListNode(tmp);
            a = 0;
            b = 0;
            pointer=pointer.next;

        }
        if(bit==1)
            pointer.next=new ListNode(1);
        return res.next;
    }
}
