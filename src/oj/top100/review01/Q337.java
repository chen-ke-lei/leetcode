package oj.top100.review01;

import oj.dto.TreeNode;

public class Q337 {
    int max = 0;

    public int rob(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }

    int[] dfs(TreeNode treeNode) {
        if (treeNode == null) return new int[3];
        int[] left = dfs(treeNode.left);
        int[] right = dfs(treeNode.right);
        int[] res = new int[3];
        res[0] = treeNode.val + Math.max(left[1], left[2]) + Math.max(right[1], right[2]);
        res[1] = Math.max(left[0] + Math.max(Math.max(right[0], right[1]), right[2]), right[0] + Math.max(Math.max(left[0], left[1]), left[2]));
        res[2] = Math.max(left[1] + Math.max(right[1], right[2]), right[1] + Math.max(left[1], left[2]));
        max = Math.max(max, res[0]);
        max = Math.max(max, res[1]);
        max = Math.max(max, res[2]);
        return res;
    }
}
