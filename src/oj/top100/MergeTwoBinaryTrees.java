package oj.top100;

import oj.dto.TreeNode;

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null)
            return t2 ;
        if(t2==null)
            return t1;
        TreeNode root=new TreeNode((t1==null?0:t1.val)+(t2==null?0:t2.val));
        root.left=mergeTrees(t1==null?null:t1.left,t2==null?null:t2.left);
        root.right=mergeTrees(t1==null?null:t1.right,t2==null?null:t2.right);
        return root;
    }
}
