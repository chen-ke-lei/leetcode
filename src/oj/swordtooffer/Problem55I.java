package oj.swordtooffer;

import oj.dto.TreeNode;

public class Problem55I {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = root.left == null ? 0 : maxDepth(root.left);
        int right = root.right == null ? 0 : maxDepth(root.right);
        return left<right?right+1:left+1;
    }
}
