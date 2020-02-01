package oj.newcoder;

import oj.dto.TreeNode;

import java.util.ArrayList;

public class BinaryTreeLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<TreeNode> preNode = new ArrayList<>(), nextNode = new ArrayList<>();
        preNode.add(root);
        pre.add(root.val);
        while (!preNode.isEmpty()) {
            res.add(pre);
            pre = new ArrayList<>();
            for (TreeNode node : preNode) {
                if (node.left != null) {
                    pre.add(node.left.val);
                    nextNode.add(node.left);
                }
                if (node.right != null) {
                    pre.add(node.right.val);
                    nextNode.add(node.right);
                }
            }
            preNode = nextNode;
            nextNode = new ArrayList<>();
        }
        return res;
    }
}
