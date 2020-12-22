package oj.top100.review01;

import oj.dto.TreeNode;

public class Q98 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean dfs(TreeNode root, long left, long right) {
        if (root == null) return true;
        if (root.val <= left || root.val >= right) return false;
        if (!dfs(root.left, left, root.val)) return false;
        if (!dfs(root.right, root.val, right)) return false;
        return true;
    }
}
