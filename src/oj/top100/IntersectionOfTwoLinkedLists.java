package oj.top100;

import oj.dto.ListNode;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a=headA;
        int lengthA=0;
        while (a!=null){
            lengthA++;
            a=a.next;
        }
        int lengthB=0;
        a=headB;
        while (a!=null){
            lengthB++;
            a=a.next;
        }
        if(lengthA<lengthB){
            a=headA;
            headA=headB;
            headB=a;
        }
        int sub=Math.abs(lengthA-lengthB);
        for(int i=0;i<sub;i++)
            headA=headA.next;
        while (headA!=null){
            if(headA==headB)
                return headA;
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
}
