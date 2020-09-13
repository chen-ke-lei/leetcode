package oj;

import oj.dto.ListNode;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null || head.next == null)
            return head;
        ListNode res = new ListNode(0);
        ListNode tmpHead = head, point = head, tmpNode, resTail = res;
        int tmp = k;
        while (point != null) {
            if (tmp == 0) {
                tmpNode = point.next;
                point.next = null;
                resTail.next = reverse(tmpHead);
                resTail = point;
                tmpHead = tmpNode;
                point = tmpHead;
                tmp = k;
            } else {
                point = point.next;
                tmp--;
            }

        }
        if (tmp != 0) {
            resTail.next = tmpHead;
        }
        return res.next;
    }

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode node = head, next = head.next, tmp;
        head.next = null;
        while (next != null) {
            tmp = next.next;
            next.next = node;
            node = next;
            next = tmp;
        }
        return node;
    }
}
