package oj.newcoder;

import oj.dto.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1), pointer = head;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    pointer.next = l1;
                    l1 = l1.next;
                } else {
                    pointer.next = l2;
                    l2 = l2.next;
                }
                pointer = pointer.next;
            }
            if (l1 == null) {
                pointer.next = l2;
                break;
            }
            if (l2 == null) {
                pointer.next = l1;
                break;
            }
        }
        return head.next;
    }
}
