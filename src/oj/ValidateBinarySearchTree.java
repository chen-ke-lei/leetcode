package oj;

import oj.dto.TreeNode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (root.right == null && root.left == null)
            return true;
        if (root.left != null) {
            if (root.val < root.left.val)
                return false;
            if (!isValidBST(root.left))
                return false;
        }
        if (root.right != null){
            if (root.val > root.right.val)
                return false;
            if (!isValidBST(root.right))
                return false;
        }
        return true;
    }
}
