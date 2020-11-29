package oj.top100;

import oj.dto.TreeNode;

public class DiameterOfBinaryTree {
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max=0;
        max(root);
        if(max>0)
            max-=1;
        return max;
    }
    int max(TreeNode node){
        if(node==null)
            return 0;
        int left=max(node.left);
        int right=max(node.right);
        int sub=Math.max(left,right);

        max=max>(left+right+1)?max:(left+right+1);


        return 1+sub;

    }
}
