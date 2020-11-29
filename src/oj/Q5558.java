package oj;

import oj.dto.ListNode;

public class Q5558 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = new ListNode(-1);
        head.next = list1;
        ListNode start = head, end = head, end2 = list2;
        while (end2 != null && end2.next != null) {
            end2 = end2.next;
        }
        for (int i = 0; i < a; i++) {
            start = start.next;
        }
        for (int i = 0; i <= b; i++) {
            end = end.next;
        }
        if (end2 != null) {
            start.next = list2;
            end2.next = end;
        } else {
            start.next = end;
        }
        return head.next;
    }
}
