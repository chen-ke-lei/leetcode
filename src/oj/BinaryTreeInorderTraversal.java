package oj;

import oj.dto.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        TreeNode node;
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        int flag = 0;
        while (!nodes.isEmpty()) {
            node = nodes.pop();
            if (flag == 0) {

                if (node.left == null) {
                    res.add(node.val);
                    if (node.right != null)
                        nodes.push(node.right);
                    else
                        flag = 1;
                } else {
                    nodes.push(node);
                    nodes.push(node.left);
                }
            } else if (flag == 1) {
                flag = 0;
                res.add(node.val);
                if (node.right != null)
                    nodes.push(node.right);
                else
                    flag = 1;
            }
        }
        return res;

    }
}
