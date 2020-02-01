package oj.newcoder.todo;

import oj.dto.ListNode;
//@TODO: 2020/1/31
public class RotateList {
    public static void main(String[] av) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        new RotateList().rotateRight(head, 3);
    }

    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++){
            if(fast.next==null)
                fast=head;


        }

        if (fast == null)
            return head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        ListNode res = slow.next;
        slow.next = null;
        return res;
    }
}
