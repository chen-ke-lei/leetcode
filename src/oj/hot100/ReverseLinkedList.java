package oj.hot100;

import oj.dto.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode node=head,next=node.next,pre=null;
        while (node.next!=null){
            next=node.next;
            node.next=pre;
            pre=node;
            node=next;
        }
        node.next=pre;
        return node;
    }
}
