package oj.interview_tips;

import oj.dto.ListNode;

public class Q02_07 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lengthA = 0, lengthB = 0;
        ListNode pointer = headA;
        while (pointer != null) {
            pointer = pointer.next;
            lengthA++;
        }
        pointer = headB;
        while (pointer != null) {
            pointer = pointer.next;
            lengthB++;
        }
        int sub = Math.abs(lengthA - lengthB);
        ListNode longNode = lengthA > lengthB ? headA : headB;
        ListNode shortNode = longNode == headA ? headB : headA;
        for (int i = 0; i < sub; i++) longNode = longNode.next;
        int minLength = Math.min(lengthA, lengthB);
        for (int i = 0; i < minLength; i++) {
            if (longNode == shortNode) return longNode;
            longNode = longNode.next;
            shortNode = shortNode.next;
        }
        return null;
    }
}
