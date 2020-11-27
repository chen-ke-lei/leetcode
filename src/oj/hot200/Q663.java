package oj.hot200;

import oj.dto.TreeNode;

public class Q663 {
    boolean res;

    public boolean checkEqualTree(TreeNode root) {
        int sum = cal(root);
        if (sum == 0 || sum % 2 == 1) return false;
        dfs(root, sum);
        return res;
    }

    int cal(TreeNode root) {
        if (root == null) return 0;
        return cal(root.left) + root.val + cal(root.right);
    }

    int dfs(TreeNode root, int sum) {
        if (res == true) return 0;
        if (root == null) return 0;
        int left = dfs(root.left, sum);
        if (res) return 0;
        int right = dfs(root.right, sum);
        if (res) return 0;
        if ((left + right + root.val) * 2 == sum) {
            res = true;
        }
        return left + right + root.val;
    }
}
