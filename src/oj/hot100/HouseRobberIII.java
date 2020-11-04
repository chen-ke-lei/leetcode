package oj.hot100;

import oj.dto.TreeNode;

public class HouseRobberIII {
    int res = 0;

    public int rob(TreeNode root) {
        //  if (root == null) return 0;
        dfs(root);
        return res;
    }

    public int[] dfs(TreeNode node) {
        if (node == null) return new int[3];
        int[] tmp = new int[3];
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        tmp[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        tmp[0] = node.val + Math.max(left[1], left[2]) + Math.max(right[1], right[2]);
        tmp[2] = tmp[1] - node.val;
        res = res > tmp[1] ? res : tmp[1];
        res = res > tmp[0] ? res : tmp[0];

        return tmp;
    }

}
