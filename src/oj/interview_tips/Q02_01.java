package oj.interview_tips;

import oj.dto.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Q02_01 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pointer = head;
        Set<Integer> set = new HashSet<>();
        set.add(pointer.val);
        while (pointer.next != null) {
            if (set.contains(pointer.next.val)) {
                pointer.next = pointer.next.next;
            } else {
                set.add(pointer.next.val);
                pointer = pointer.next;
            }
        }
        return head;
    }
}
