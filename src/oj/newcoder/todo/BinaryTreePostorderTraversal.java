package oj.newcoder.todo;

import oj.dto.TreeNode;

import java.util.ArrayList;
import java.util.Stack;
// TODO: 2020/1/30
public class BinaryTreePostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null)
            stack.push(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            pre = stack.peek();

        }
        return res;
    }
}
