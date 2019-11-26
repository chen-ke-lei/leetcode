package src.linked;

import oj.dto.ListNode;

public class ReverseLinked {
    static public ListNode createList(int num) {
        ListNode head = new ListNode(0), point = head;
        for (int i = 1; i <= num; i++) {
            ListNode tmp = new ListNode(i);
            point.next = tmp;
            point = tmp;
        }
        return head;
    }

    static public void displayList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
    }

    static public void reverse(ListNode head) {
        ListNode pre = head, next = head.next;
        head.next = null;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = pre;
            pre = next;
            next = tmp;
        }
        displayList(pre);
    }
    public static void main(String[]av){
        reverse(createList(10));
    }
}
