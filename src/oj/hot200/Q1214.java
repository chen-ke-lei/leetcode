package oj.hot200;

import oj.dto.TreeNode;

public class Q1214 {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null || root2 == null) return false;
        if (root1.val + root2.val == target) return true;
        if (root1.val + root2.val < target) {
            if (twoSumBSTs(root1.right, root2, target)) return true;
            if (twoSumBSTs(root1, root2.right, target)) return true;
        } else {
            if (twoSumBSTs(root1.left, root2, target)) return true;
            if (twoSumBSTs(root1, root2.left, target)) return true;
        }
        return false;
    }
}
