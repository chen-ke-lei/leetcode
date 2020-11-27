package oj.interview_tips;

import oj.dto.TreeNode;

public class Q04_04 {
    boolean bal = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return bal;
    }

    int dfs(TreeNode node) {
        if (!bal) return -1;
        if (node == null) return 0;
        int left = dfs(node.left);
        if (!bal) return -1;
        int right = dfs(node.right);
        if (!bal) return -1;
        if (Math.abs(left - right) > 1) {
            bal = false;
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
