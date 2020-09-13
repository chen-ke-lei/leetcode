package oj.hot100;

import oj.dto.TreeNode;

public class ConvertBSTToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        dfsRight(root);
        dfsLeft(root);
        return root;
    }

    public int dfsRight(TreeNode node){
        if(node==null)
            return 0;
        node.val+=dfsRight(node.right);
        return node.val;
    }
    public void dfsLeft(TreeNode node){
        if(node==null||node.left==null)
            return;
        node.left.val+=node.val;
        dfsRight(node.left);
    }

}
