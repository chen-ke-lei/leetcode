package oj.hot100;

import oj.dto.TreeNode;

public class ValidateBinarySearchTree {
    boolean valid = true;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        dfs(root, 1);
        return valid;
    }

    int dfs(TreeNode node, int sign) {
        if (!valid)
            return -1;
        if (node.right == null && node.left == null)
            return node.val;
        int left = Integer.MIN_VALUE;
        if (node.left != null)
            left = dfs(node.left, -1);
        if (!valid)
            return -1;
        int right = Integer.MAX_VALUE;
        if (node.right != null)
            right = dfs(node.right, 1);
        if (!valid)
            return -1;
        if (node.val < left || node.val > right) {
            valid = false;
            return -1;
        }
        if(sign==-1){
            return node.right != null ? right : node.val;
        }else {
            return node.left != null ? left : node.val;
        }


    }
}
