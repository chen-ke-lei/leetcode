package oj.newcoder;

import oj.dto.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode node = new ListNode(1);
        node.next = head;
        ListNode pre = node, pointer = head, tmp;
        while (pointer!=null&&pointer.next != null) {
            tmp = pointer.next;
            pointer.next = tmp.next;
            tmp.next = pointer;
            pre.next = tmp;
            pre=pointer;
            pointer=pre.next;
        }
        return node.next;
    }
}
