package oj.hot100;

import oj.dto.TreeNode;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        if(root==null)
            return 0;
        int left=rob(root.left);
        int right=rob(root.right);
        return Math.max(left,right)+root.val;
    }
}
