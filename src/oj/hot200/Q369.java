package oj.hot200;

import oj.dto.ListNode;
import oj.dto.TreeNode;

public class Q369 {
    public ListNode plusOne(ListNode head) {
        head = reverse(head);
        ListNode point = head, pre = head;
        int bit = 1;
        while (point != null) {
            point.val += bit;
            if (point.val >= 10) {
                point.val = point.val % 10;
                bit = 1;
            } else
                bit = 0;
            pre = point;
            point = point.next;
        }
        if (bit == 1) {
            pre.next = new ListNode(1);
        }
        return reverse(head);
    }

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head, next = head.next, tmp;
        head.next = null;
        while (next != null) {
            tmp = next.next;
            next.next = pre;
            pre = next;
            next = tmp;

        }
        return pre;
    }

    public static void main(String[] args) {
        System.out.println(new Q369().reverse(ListNode.create(new int[]{1,2,3})));
    }
}
