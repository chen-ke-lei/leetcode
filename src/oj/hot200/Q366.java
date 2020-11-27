package oj.hot200;

import oj.dto.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<TreeNode> pre = new ArrayList<>(), next = new ArrayList<>();
        List<List<Integer>> res = new LinkedList<>();
        pre.add(root);
        while (!pre.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            boolean fix = false;
            for (TreeNode node : pre) {
                if (node.left == null && node.right == null) {
                    next.add(node);
                } else {
                    tmp.add(node.val);
                }
                if (node.left != null) {
                    fix = true;
                    next.add(node.left);
                }
                if (node.right != null) {
                    fix = true;
                    next.add(node.right);
                }
            }
            res.add(0, tmp);
            if (!fix) {
                tmp = new ArrayList<>();
                for (TreeNode node : pre) {
                    tmp.add(node.val);
                    res.add(0, tmp);
                    return res;
                }
            }
            pre = next;
            next = new ArrayList<>();
        }
        return res;
    }

}
