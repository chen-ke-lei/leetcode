package oj.newcoder;

import oj.dto.TreeNode;

public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;

    public static void main(String[] av) {
        TreeNode treeNode = new TreeNode(-2);
        treeNode.left = new TreeNode(-1);
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(treeNode));
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    int dfs(TreeNode root) {
        if (root == null)
            return 0;
        max = max > root.val ? max : root.val;
        Integer left = null, right = null;
        if (root.left != null) {
            left = dfs(root.left);
            max = max > left ? max : left;
        }
        if (root.right != null) {
            right = dfs(root.right);
            max = max > right ? max : right;
        }
        if (left == null||left<0)
            left = 0;
        if (right == null||right<0)
            right = 0;
        int tmp = left + right + root.val;
        max = max > tmp ? max : tmp;
        return left>right?left+root.val:right+root.val ;
    }
}
