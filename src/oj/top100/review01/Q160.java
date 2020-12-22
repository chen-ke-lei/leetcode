package oj.top100.review01;

import oj.dto.ListNode;

public class Q160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node = headA;
        int lenA = 0;
        while (node != null) {
            lenA++;
            node = node.next;
        }
        int lenB = 0;
        node = headB;
        while (node != null) {
            lenB++;
            node = node.next;
        }
        while (lenA > 0 && lenB > 0) {
            if (lenA > lenB) {
                lenA--;
                headA = headA.next;
            } else if (lenB > lenA) {
                lenB--;
                headB = headB.next;
            } else {
                if (headA == headB) return headA;
                lenA--;
                lenB--;
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}
