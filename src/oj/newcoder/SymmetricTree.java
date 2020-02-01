package oj.newcoder;

import oj.dto.TreeNode;

import java.util.Stack;

public class SymmetricTree {
//    public boolean isSymmetric(TreeNode root) {
////        if (root == null)
////            return true;
////        if (!doubleDfs(root.left, root.right))
////            return false;
////        return true;
////    }
////
////    boolean doubleDfs(TreeNode left, TreeNode right) {
////        if (left == null && right == null)
////            return true;
////        if (left == null || right == null)
////            return false;
////        if (left.val != right.val)
////            return false;
////        if (!doubleDfs(left.left, right.right)) return false;
////        if (!doubleDfs(left.right, right.left)) return false;
////        return true;
////    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        if (root.left == null || root.right == null)
            return false;
        Stack<TreeNode> leftTree = new Stack<>();
        Stack<TreeNode> rightTree = new Stack<>();
        leftTree.push(root.left);
        rightTree.push(root.right);
        while (!leftTree.isEmpty() && !leftTree.isEmpty()) {
            TreeNode leftNode = leftTree.pop();
            TreeNode rightNode = rightTree.pop();
            if (leftNode.val != rightNode.val)
                return false;
            if ((leftNode.left == null && rightNode.right != null) || (leftNode.left != null && rightNode.right == null))
                return false;
            if (leftNode.left != null) {
                leftTree.push(leftNode.left);
                rightTree.push(rightNode.right);
            }
            if ((leftNode.right == null && rightNode.left != null) || (leftNode.right != null && rightNode.left == null))
                return false;
            if (leftNode.right != null) {
                leftTree.push(leftNode.right);
                rightTree.push(rightNode.left);
            }

        }
        if (!leftTree.isEmpty() || !rightTree.isEmpty())
            return false;
        return true;
    }
}
