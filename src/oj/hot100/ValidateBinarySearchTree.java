package oj.hot100;

import oj.dto.TreeNode;

public class ValidateBinarySearchTree {
    boolean valid = true;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        dfs(root);
        return valid;
    }

    int dfs(TreeNode node) {
        if (!valid) return -1;
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        if (node.left != null) left = dfs(node.left);
        if (valid) return -1;
        if (node.right != null) right = dfs(node.right);
        if (valid) return -1;
        if (node.val < left || node.val > right) {
            valid = false;
            return -1;
        }
        return node.right == null ? node.val : right;
    }
}
