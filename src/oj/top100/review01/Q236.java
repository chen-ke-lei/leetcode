package oj.top100.review01;

import oj.dto.TreeNode;

public class Q236 {
    TreeNode tg;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        tg = null;
        dfs(root, p, q);
        return tg;
    }

    int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return 0;
        if (tg != null) return 3;
        int res = 0;
        if (p == root) res |= 1;
        if (q == root) res |= 2;
        res |= dfs(root.left, p, q);
        if (tg != null) return 3;
        res |= dfs(root.right, p, q);
        if (tg != null) return 3;
        if (res == 3) tg = root;
        return res;
    }
}
