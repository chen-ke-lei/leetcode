package oj.hot100;

import oj.dto.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;

        return dfs(root.left,root.right);
    }
    boolean dfs(TreeNode left,TreeNode right){
        if(left==null&&right==null)
            return true;
        if(left==null||right==null)
            return false;
        if(left.val!=right.val)
            return false;
        if(!dfs(left.left,right.right)) return false;
        if(!dfs(left.right,right.left)) return false;
        return true;
    }
}
