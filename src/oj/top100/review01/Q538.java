package oj.top100.review01;

import oj.dto.TreeNode;

public class Q538 {
    int high = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        return root;
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        high += root.val;
        root.val = high;
        dfs(root.left);

    }
}
