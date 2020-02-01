package oj.newcoder.todo;

import oj.dto.ListNode;

// TODO: 2020/2/1  
public class InsertionSortList {
    public static void main(String[] av) {
        ListNode node = new ListNode(2);
        node.next = new ListNode(1);
        new InsertionSortList().insertionSortList(node);
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode tmpHead = new ListNode(0);
        tmpHead.next = head;
        ListNode pre, prepointer = head, pointer = head.next;
        while (pointer != null) {
            pre = tmpHead;
            while (pre.next != pointer) {
                if (pointer.val < pre.next.val) {
                    ListNode a = pre.next, b = pointer;
                    pre.next = b;
                    b.next = a.next;
                }
                pre = pre.next;
            }
            prepointer = pointer;
            pointer = pointer.next;
        }
        return tmpHead.next;
    }

}
