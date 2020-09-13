package oj;

import oj.dto.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> pre = new ArrayList<>(), next = new ArrayList<>();
        pre.add(root);
        List<Integer> tmp = new ArrayList<>();
        tmp.add(root.val);
        res.add(tmp);
        while (!pre.isEmpty()) {
            next = new ArrayList<>();
            tmp = new ArrayList<>();
            for (TreeNode node : pre) {
                if (node.left != null) {
                    next.add(node.left);
                    tmp.add(node.left.val);
                }
                if (node.right != null) {
                    next.add(node.right);
                    tmp.add(node.right.val);
                }
            }
            if (!tmp.isEmpty())
                res.add(tmp);
            pre = next;
        }
        Collections.reverse(res);
        return res;
    }
}
