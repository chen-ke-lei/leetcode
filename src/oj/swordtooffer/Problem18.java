package oj.swordtooffer;

import oj.dto.ListNode;

public class Problem18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node, pointer = head;
        while (pointer != null) {
            if (pointer.val == val) {
                pre.next = pointer.next;
                pre = pre.next;
                if (pre != null)
                    pointer = pre.next;
                else
                    break;
            } else {
                pre = pointer;
                pointer = pointer.next;
            }
        }

        return node.next;
    }
}
