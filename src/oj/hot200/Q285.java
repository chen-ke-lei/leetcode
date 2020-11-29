package oj.hot200;

import oj.dto.TreeNode;

public class Q285 {
    TreeNode res = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root, p);
        return res;
    }

    void dfs(TreeNode root, TreeNode p) {
        if (root != null) {
            dfs(root.right, p);
            if (p.val < root.val) {
                res = root;
                dfs(root.left, p);
            }
        }
    }
}
