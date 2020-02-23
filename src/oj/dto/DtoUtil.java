package oj.dto;

public class DtoUtil {
    public static void displayListNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "--");
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode creatListByArray(int[] a) {
        if (a == null || a.length == 0)
            return null;
        ListNode head = new ListNode(a[0]), pointer = head;
        for (int i = 1; i < a.length; i++) {
            pointer.next = new ListNode(a[i]);
            pointer = pointer.next;
        }
        return head;
    }
}
