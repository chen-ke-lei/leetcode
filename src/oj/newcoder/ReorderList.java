package oj.newcoder;

import oj.dto.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;
        //�ҵ�������м�λ��
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode medium = slow.next;
        slow.next = null;
        //�Ժ�벿�������������
        ListNode pre = medium, next = medium.next, tmp = null;
        pre.next = null;
        while (next != null) {
            tmp = next.next;
            next.next = pre;
            pre = next;
            next = tmp;
        }
        //pre�Ǳ�ͷ���ϲ�
        fast = head;
        slow = pre;
        while (slow != null) {
            tmp = fast.next;
            fast.next = slow;
            fast = fast.next;
            slow = slow.next;
            fast.next = tmp;
            fast = fast.next;
        }

    }
}
