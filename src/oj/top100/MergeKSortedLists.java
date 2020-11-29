package oj.top100;

import oj.dto.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res=new ListNode(-1),point=res;
        PriorityQueue<ListNode> queue=new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for(ListNode node:lists)
            queue.offer(node);
        while (!queue.isEmpty()){
            ListNode node=queue.poll();
            point.next=node;
            point=point.next;
            node=node.next;
            if(node!=null)
                queue.offer(node);
        }
        return res.next;
    }
}
