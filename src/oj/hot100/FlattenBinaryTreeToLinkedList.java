package oj.hot100;

import oj.dto.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        TreeNode left=root.left;
        TreeNode right=root.right;
        flatten(left);
        root.right=left;
        flatten(right);
        root.left=null;
        while (root.right!=null)
            root=root.right;
        root.right=right;
    }
}
