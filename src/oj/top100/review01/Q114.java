package oj.top100.review01;

import oj.dto.TreeNode;

public class Q114 {
    public void flatten(TreeNode root) {
        dfs(root);
    }

    TreeNode dfs(TreeNode root) {
        if (root == null) return null;
        TreeNode leftEnd = null, rightEnd = null;
        if (root.left != null) {
            leftEnd = dfs(root.left);
        }
        if (root.right != null) {
            rightEnd = dfs(root.right);
        }
        if (leftEnd == null && rightEnd == null) return root;
        if (leftEnd != null) {
            leftEnd.right = root.right;
            root.right = root.left;
            root.left = null;
            return rightEnd == null ? leftEnd : rightEnd;
        } else {
            return rightEnd;
        }
    }
}
