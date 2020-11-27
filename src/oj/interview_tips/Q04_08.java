package oj.interview_tips;

import oj.dto.TreeNode;

public class Q04_08 {
    TreeNode node = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return node;
    }

    int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (node != null)
            return 3;
        if (root == null) return 0;
        int left = dfs(root.left, p, q);
        int right = dfs(root.right, p, q);
        int res = 0;
        if (root == p) res |= 1;
        if (root == q) res |= 2;
        res = res | left | right;
        if (res == 3 && node == null) node = root;
        return res;
    }
}
