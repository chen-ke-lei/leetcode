package oj.hot200;

import oj.dto.TreeNode;

public class Q250 {
    int num = 0;

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        dfs(root);
        return num;
    }

    boolean dfs(TreeNode node) {
        if (node.right == null && node.left == null) {
            num++;
            return true;
        }
        boolean left = true, right = true, res = true;
        if (node.left != null) {
            left = dfs(node.left);
            if (left && node.left.val == node.val && res) {
                res = true;
            } else {
                res = false;
            }
        }
        if (node.right != null) {
            right = dfs(node.right);
            if (right && node.right.val == node.val && res) {
                res = true;
            } else {
                res = false;
            }
        }
        if (res) num++;

        return res;
    }
}
