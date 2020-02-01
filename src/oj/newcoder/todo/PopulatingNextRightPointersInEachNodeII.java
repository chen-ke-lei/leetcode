package oj.newcoder.todo;

import oj.dto.TreeLinkNode;

// TODO: 2020/2/1  
public class PopulatingNextRightPointersInEachNodeII {
    public static void main(String[] av) {
        TreeLinkNode node = new TreeLinkNode(1);
        node.left = new TreeLinkNode(2);
        node.right = new TreeLinkNode(3);
        new PopulatingNextRightPointersInEachNodeII().connect(node);
    }

    public void connect(TreeLinkNode root) {
        if (root == null || root.left == null)
            return;
        TreeLinkNode pre = root, next = null, preBegin = pre;
        while (preBegin != null) {
            preBegin = null;
            while (pre != null) {
                if (pre.left != null || pre.right != null) {
                    if (pre.left != null) {
                        if (next != null) {
                            next.next = pre.left;
                        }
                        next = pre.left;
                        if (preBegin == null)
                            preBegin = next;
                    }
                    if (pre.right != null) {
                        if (next != null) {
                            next.next = pre.right;
                        }
                        next = pre.right;
                        if (preBegin == null)
                            preBegin = next;
                    }
                }
                pre = pre.next;
            }
            pre = preBegin;
            next = null;
        }
    }
}
