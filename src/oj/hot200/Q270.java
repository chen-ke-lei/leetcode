package oj.hot200;

import oj.dto.TreeNode;

public class Q270 {
    public int closestValue(TreeNode root, double target) {
        double min = -1;
        int res = 0;
        if (target == root.val) return root.val;
        TreeNode node = root;
        while (node != null) {
            double tmp;
            int nodeVal = node.val;
            if (node.val > target) {
                tmp = node.val - target;
                node = node.left;

            } else {
                tmp = target - node.val;
                node = node.right;

            }
            if (min == -1 || min > tmp) {
                res = nodeVal;
                min = tmp;
            }
        }
        return res;
    }
}
