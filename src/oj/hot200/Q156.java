package oj.hot200;

import oj.dto.TreeNode;

public class Q156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) return root;
        TreeNode res = root;
        while (res.left != null)
            res = res.left;
        dfs(root, null, null);
        return res;
    }

    void dfs(TreeNode root, TreeNode left, TreeNode right) {
        TreeNode x = root.left, y = root.right;
        root.left = left;
        root.right = right;
        if (x != null) dfs(x, y, root);
    }
}
