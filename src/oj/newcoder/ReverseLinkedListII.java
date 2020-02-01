package oj.newcoder;

import oj.dto.ListNode;

public class ReverseLinkedListII {
    public static void main(String[] av) {
        ListNode root = new ListNode(3);
        root.next = new ListNode(5);
        new ReverseLinkedListII().reverseBetween(root,1,2);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n)
            return head;
        ListNode add = new ListNode(-1), pre, next, tmp, rstart, rend;
        pre = add;
        add.next = head;
        for (int i = 1; i < m; i++)
            pre = pre.next;
        rstart = pre;
        System.out.println(pre.val);
        pre = pre.next;
        rend = pre;
        next = pre.next;
        System.out.println(next.val);
        for (int i = 0; i < n - m; i++) {
            tmp = next.next;
            next.next = pre;
            pre = next;
            next = tmp;
        }
        rstart.next = pre;
        rend.next = next;
        return add.next;
    }
}
