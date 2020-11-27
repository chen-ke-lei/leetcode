package oj.hot200;

import oj.dto.TreeNode;

public class Q298 {
    int max = 0;

    public int longestConsecutive(TreeNode root) {
        dfs(root, root.val - 3, 1);
        return max;
    }

    void dfs(TreeNode node, Integer par, int k) {
        if (par + 1 == node.val) k++;
        else k = 1;

        max = max > k ? max : k;
        if (node.left != null)
            dfs(node.left, node.val, k);
        if (node.right != null)
            dfs(node.right, node.val, k);
    }
}
