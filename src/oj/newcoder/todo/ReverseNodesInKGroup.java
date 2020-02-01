package oj.newcoder.todo;

import oj.dto.ListNode;
// TODO: 2020/1/31
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode line = new ListNode(1);
        line.next=head;
        ListNode  ori=line,pre=line,next=head,tmp;
        while (line!=null){
            for(int i=0;i<k&&pre!=null;i++){

            }
        }

        return ori.next;
    }
}
