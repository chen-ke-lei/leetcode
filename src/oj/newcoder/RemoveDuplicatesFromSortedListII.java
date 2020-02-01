package oj.newcoder;

import oj.dto.ListNode;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        boolean isDup = false;
        int dupVal = -1;
        ListNode realHead = new ListNode(head.val - 1);
        realHead.next = head;
        ListNode par = realHead, pre = head, next = head.next;
        while (next != null) {
            if (isDup && next.val == dupVal) {
                next = next.next;
            } else if (isDup && next.val != dupVal) {
                isDup = false;
                par.next = next;
                pre = next;
                next = next.next;

            } else if (pre.val == next.val) {
                isDup = true;
                dupVal = pre.val;
                pre = next;
                next = next.next;
            } else {
                par = pre;
                pre = next;
                next = next.next;
            }

        }
        if (isDup)
            par.next = null;
        return realHead.next;
    }
}
