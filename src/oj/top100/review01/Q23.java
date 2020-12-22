package oj.top100.review01;

import oj.dto.ListNode;

import java.util.PriorityQueue;

public class Q23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1), point = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) queue.offer(list);
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            point.next = node;
            point = point.next;
            if (node.next != null) queue.offer(node.next);
        }
        return head.next;
    }
}
