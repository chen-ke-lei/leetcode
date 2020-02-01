package oj.newcoder;

import oj.dto.TreeNode;

public class MinimumDepthOfBinaryTree {
    public int run(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int left = -1, right = -1;
        if (root.left != null)
            left = run(root.left);
        if (root.right != null)
            right = run(root.right);
        if(left==-1)return right+1;
        if(right==-1)return left+1;
        return left < right ? left + 1 : right + 1;
    }
}
