package oj.interview_tips;

import oj.dto.TreeNode;

public class Q04_05 {
    public boolean isValidBST(TreeNode root) {
        return dfs(Long.MIN_VALUE, root, Long.MAX_VALUE);
    }

    boolean dfs(long left, TreeNode node, long right) {
        if (node == null) return true;
        if (node.val <= left || node.val >= right) return false;
        if (!dfs(left, node.left, node.val)) return false;
        if (!dfs(node.val, node.right, right)) return false;
        return true;
    }
}
