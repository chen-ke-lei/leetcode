package oj.hot100;

import oj.dto.TreeNode;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return dfs(root);

    }

    boolean dfs(TreeNode node) {

        if (node.left != null && !dfs(node.left)) return false;
        if (node.right != null && !dfs(node.right)) return false;
        if (node.left != null && node.val <= findMax(node.left)) {
            return false;
        }
        if (node.right != null && node.val >= findMin(node.right)) {
            return false;
        }
        return true;

    }

    int findMax(TreeNode node) {
        int val = node.val;
        if (node.left != null) val = Math.max(val, findMax(node.left));
        if (node.right != null) val = Math.max(val, findMax(node.right));
        return val;
    }

    int findMin(TreeNode node) {
        int val = node.val;
        if (node.left != null) val = Math.min(val, findMin(node.left));
        if (node.right != null) val = Math.min(val, findMin(node.right));
        return val;
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.creatTreeByString("[3,1,5,0,2,4,6,null,null,null,3]");
        new ValidateBinarySearchTree().isValidBST(node);
    }
}
