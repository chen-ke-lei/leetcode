package oj.top100;

import oj.dto.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode head=new ListNode(-1),tmp=head;
        while (l1!=null||l2!=null){
            if(l1==null){
                tmp.next=l2;
                break;
            }
            if(l2==null){
                tmp.next=l1;
                break;
            }
            if(l1.val<=l2.val){
                tmp.next=l1;
                tmp=tmp.next;
                l1=l1.next;
            }else {
                tmp.next=l2;
                tmp=tmp.next;
                l2=l2.next;
            }

        }
        return head.next;
    }
}
