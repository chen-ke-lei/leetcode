package oj.interview_tips;

import oj.dto.TreeNode;

public class Q04_06 {
    TreeNode res = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root, p);
        return res;
    }

    public TreeNode dfs(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (root == p) {
            if (root.right != null)
                res = root.right;

            return root;
        }
        if (dfs(root.left, p) == p) {
            res = root;
            return null;
        }
        TreeNode node = dfs(root.right, p);
        if (node == p) {
            return node;
        }
        return null;
    }
}
