package oj.newcoder;

import oj.dto.TreeNode;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return  left>right?left+1:right+1;
    }
}
