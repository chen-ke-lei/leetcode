package oj.newcoder;

import oj.dto.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root.left;
        stack.push(root);
        while (!stack.isEmpty()) {
            if (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            } else {
                tmp = stack.pop();
                res.add(tmp.val);
                if (tmp.right != null) {
                    stack.push(tmp.right);
                    tmp = tmp.right.left;
                } else {
                    tmp = null;
                }
            }
        }
        return res;
    }
}
