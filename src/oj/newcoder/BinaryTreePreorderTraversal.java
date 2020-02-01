package oj.newcoder;

import oj.dto.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            if (tmp.right != null)
                stack.push(tmp.right);
            if (tmp.left != null)
                stack.push(tmp.left);
        }
        return res;
    }
}
