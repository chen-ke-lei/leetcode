package oj.newcoder;

import oj.dto.TreeLinkNode;


public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null || root.left == null)
            return;
        TreeLinkNode pre = root, next = null, preBegin = pre;
        while (preBegin != null) {
            while (pre != null) {
                if (pre.left != null) {
                    if (next != null)
                        next.next = pre.left;
                    pre.left.next = pre.right;
                    if (pre.right != null) {
                        next = pre.right;
                    } else {
                        break;
                    }

                } else {
                    break;
                }
                pre = pre.next;
            }
            pre = preBegin.left;
            preBegin = pre;
            next=null;
        }

    }
}
