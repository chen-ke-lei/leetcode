package oj.newcoder.todo;

import oj.dto.TreeNode;

// TODO: 2020/2/1  
public class ValidateBinarySearchTree {
    int maxVal = Integer.MIN_VALUE;
    int minVal = Integer.MAX_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        if (root.left != null) {
            minVal = root.left.val < minVal ? root.left.val : minVal;
            if (!isValidBST(root.left))
                return false;
            if (root.val <= root.left.val)
                return false;
            if (root.val <= maxVal)
                return false;
        }
        if (root.right != null) {
            maxVal = root.right.val > maxVal ? root.right.val : maxVal;
            if (!isValidBST(root.right))
                return false;
            if (root.val >= root.right.val)
                return false;
            if (root.val >= minVal)
                return false;
        }
        return true;

    }
}
