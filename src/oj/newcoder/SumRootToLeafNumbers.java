package oj.newcoder;

import oj.dto.TreeNode;

public class SumRootToLeafNumbers {
    int sum;
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        sum = 0;
        dfs(root, 0);
        return sum;
    }
    void dfs(TreeNode root, int sub) {
        if (root.left == null && root.right == null)
            sum += sub * 10 + root.val;
        if(root.left!=null)
            dfs(root.left,sub*10+root.val);
        if(root.right!=null)
            dfs(root.right,sub*10+root.val);
    }
}
