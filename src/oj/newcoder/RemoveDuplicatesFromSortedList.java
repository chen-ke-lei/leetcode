package oj.newcoder;

import oj.dto.ListNode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;
        while (pre != null && pre.next != null) {
            if (pre.val == pre.next.val) {
                pre.next = pre.next.next;
            } else
                pre = pre.next;
        }
        return head;
    }
}
