package oj.newcoder;

import oj.dto.TreeNode;

import java.util.ArrayList;

public class BinaryTreeZigzagLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        boolean reverse = false;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<TreeNode> preNode = new ArrayList<>(), nextNode = new ArrayList<>();
        preNode.add(root);
        pre.add(root.val);
        while (!preNode.isEmpty()) {
            if (reverse) {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int i = pre.size() - 1; i >= 0; i--) {
                    tmp.add(pre.get(i));
                }
                pre = tmp;
            }
            res.add(pre);
            pre = new ArrayList<>();
            reverse = !reverse;
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
