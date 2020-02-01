package oj.newcoder;

import oj.dto.TreeNode;

public class BalancedBinaryTree {
    boolean bal = true;

    public boolean isBalanced(TreeNode root) {
        bal = true;
        calculHeight(root);
        return bal;
    }

    int calculHeight(TreeNode root) {
        if (!bal || root == null)
            return 0;
        int left = calculHeight(root.left);
        int right = calculHeight(root.right);
        if ((left > right && left - right > 1) || (right > left && right - left > 1)) bal = false;
        return left > right ? left + 1 : right + 1;
    }
}
