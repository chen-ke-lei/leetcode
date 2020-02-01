package oj.newcoder;

import oj.dto.ListNode;
import oj.dto.TreeNode;

public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);
        TreeNode root ;
        ListNode slow = head, fast = head, tmp = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            tmp = slow;
            slow = slow.next;
        }
        tmp.next = null;
        root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
