package oj.interview_tips;

import oj.dto.ListNode;
import oj.dto.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q04_03 {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) return new ListNode[0];
        List<ListNode> res = new ArrayList<>();
        List<TreeNode> pre = new ArrayList<>(), next = new ArrayList<>();
        pre.add(tree);
        while (!pre.isEmpty()) {
            ListNode head = new ListNode(-1), pointer = head;
            for (TreeNode node : pre) {
                pointer.next = new ListNode(node.val);
                pointer = pointer.next;
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            pre = next;
            next = new ArrayList<>();
            res.add(head.next);

        }
        return res.toArray(new ListNode[res.size()]);
    }
}
