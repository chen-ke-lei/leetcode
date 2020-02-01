package oj.newcoder;

import oj.dto.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.right == null && root.left == null && root.val == sum)
            return true;
        if (root.right == null && root.left == null && root.val != sum)
            return false;
        if (hasPathSum(root.left, sum - root.val)) return true;

        if (hasPathSum(root.right, sum - root.val)) return true;
        return false;
    }
}
