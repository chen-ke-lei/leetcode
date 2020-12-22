package oj.top100.review01;

import oj.dto.TreeNode;

public class Q534 {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(left + right , max);
        return Math.max(left, right) + 1;
    }
}
