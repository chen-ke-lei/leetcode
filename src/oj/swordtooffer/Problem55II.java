package oj.swordtooffer;

import oj.dto.TreeNode;

public class Problem55II {
    boolean bal = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        dfs(root);
        return bal;
    }

    int dfs(TreeNode root) {
        if (!bal)
            return -1;
        if (root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == -1 || right == -1)
            return -1;
        int sub = left > right ? left - right : right - left;
        if (sub > 1) {
            bal = false;
            return -1;
        }
        return left > right ? left + 1 : right + 1;
    }
}
