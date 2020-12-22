package oj.top100.review01;

import oj.dto.ListNode;

public class Q148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head,pre=slow;
        while (fast != null && fast.next != null) {
            pre=slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next=null;
        ListNode head1 = sortList(head);
        ListNode head2 = sortList(slow);
        ListNode res = new ListNode(-1), tmp = res;

        while (head1 != null || head2 != null) {
            if (head1 == null) {
                tmp.next = head2;
                break;
            }
            if (head2 == null) {
                tmp.next = head1;
                break;
            }
            if (head1.val < head2.val) {
                tmp.next = head1;
                head1 = head1.next;
                tmp = tmp.next;
            } else {
                tmp.next = head2;
                head2 = head2.next;
                tmp = tmp.next;
            }
        }
        return res.next;
    }
}
