package oj.swordtooffer;

import oj.dto.ListNode;

public class Problem52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int alength = 0, blength = 0;
        ListNode tmpA = headA, tmpB = headB;
        while (tmpA != null || tmpB != null) {
            if (tmpA != null) {
                tmpA = tmpA.next;
                alength++;
            }
            if (tmpB != null) {
                tmpB = tmpB.next;
                blength++;
            }
        }
        ListNode longList = alength > blength ? headA : headB;
        ListNode shortList = longList == headA ? headB : headA;
        int sub = alength > blength ? (alength - blength) : (blength - alength);
        for (int i = 0; i < sub; i++)
            longList = longList.next;
        while (longList != null) {
            if (longList == shortList)
                return longList;
            longList = longList.next;
            shortList = shortList.next;
        }
        return null;
    }
}
