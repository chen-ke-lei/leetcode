package oj.top100.review01;

import oj.dto.TreeNode;

public class Q124 {
    long max;

    public int maxPathSum(TreeNode root) {
        max = root.val;
        dfs(root);
        return (int) max;
    }

    long dfs(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        long leftVal = dfs(root.left);
        long rightVal = dfs(root.right);
        max = Math.max(root.val, max);
        max = Math.max(max, root.val + leftVal);
        max = Math.max(max, root.val + rightVal);
        max = Math.max(max, root.val + rightVal + leftVal);
        return Math.max(root.val, Math.max(root.val + leftVal, rightVal + root.val));

    }
}
