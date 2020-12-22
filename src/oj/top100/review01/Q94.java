package oj.top100.review01;

import oj.dto.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        TreeNode node = null;
        while (!nodes.isEmpty()) {
            while (nodes.peek().left != null)
                nodes.push(nodes.peek().left);
            while (!nodes.isEmpty() && (node = nodes.pop()) != null && node.right == null) {
                res.add(node.val);
            }
            if (node==null||node.right == null) return res;
            res.add(node.val);
            nodes.push(node.right);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.creatTreeByString("[3,1,null,null,2]");
        System.out.println(new Q94().inorderTraversal(node));
    }
}
