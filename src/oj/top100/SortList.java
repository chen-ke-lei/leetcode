package oj.top100;

import oj.dto.ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode slow=head,fast=head.next;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode tmp=slow.next;
        slow.next=null;
        ListNode f=sortList(head);

        ListNode s=sortList(tmp);
        ListNode re=new ListNode(-1),pointer=re;
        while (f!=null&&s!=null){
            if(f.val<=s.val){
                pointer.next=f;
                f=f.next;
            }else {
                pointer.next=s;
                s=s.next;
            }
            pointer=pointer.next;
        }

        if(f!=null)pointer.next=f;
        if(s!=null)pointer.next=s;
        return re.next;
    }

    public static void main(String[] args) {
        ListNode head=ListNode.create(new  int[]{4,2,1,3});
        System.out.println(new SortList().sortList(head));
    }
}
