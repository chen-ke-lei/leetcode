package oj.hot200;

import oj.dto.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q545 {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);
        TreeNode node = root.left;
        while (node != null && (node.left != null || node.right != null)) {
            res.add(node.val);
            node = node.left == null ? node.right : node.left;
        }
        dfs(root.left, res);
        dfs(root.right, res);
        Stack<Integer> stack = new Stack<>();
        node = root.right;
        while (node != null && (node.left != null || node.right != null)) {
            stack.push(node.val);
            node = node.right == null ? node.left : node.right;
        }
        while (!stack.isEmpty())
            res.add(stack.pop());
        return res;
    }

    void dfs(TreeNode node, List<Integer> res) {
        if(node==null)return;
        if (node.left != null)
            dfs(node.left, res);
        if (node.left == null && node.right == null)
            res.add(node.val);
        if (node.right != null)
            dfs(node.right, res);
    }
    public static void main(String[] args) {
        System.out.println(new Q545().boundaryOfBinaryTree(TreeNode.creatTreeByString("[1,null,2,3,4]")));
    }
}
