package oj.top100.review01;

import oj.dto.TreeNode;

public class Q101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        if (n1.val != n2.val) return false;
        if (!dfs(n1.left, n2.right)) return false;
        if (!dfs(n1.right, n2.left)) return false;
        return true;

    }
}
