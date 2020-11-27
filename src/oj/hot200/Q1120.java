package oj.hot200;

import oj.dto.TreeNode;

public class Q1120 {
    double max = Integer.MIN_VALUE;

    public double maximumAverageSubtree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }

    int dfs(TreeNode root) {
        int num = 1;
        if (root.left != null) {
            num += dfs(root.left);
            root.val += root.left.val;
        }
        if (root.right != null) {
            num += dfs(root.right);
            root.val += root.right.val;
        }
        max = max > (root.val / (num*1.0)) ? max : (root.val / (num*1.0));
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new Q1120().maximumAverageSubtree(TreeNode.creatTreeByString("[2,null,1]")));
    }
}
