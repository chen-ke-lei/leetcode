package oj.hot100;

import oj.dto.TreeNode;


public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        return dfs(preorder,inorder,0,preorder.length-1,0,preorder.length-1);
    }
    TreeNode dfs(int[] preorder, int[] inorder,int pS,int pE,int iS,int iE){
        if(pS>pE)
            return null;
        if(pS==pE)
            return new TreeNode(preorder[pS]);
        int tmp=preorder[pS];
        TreeNode node=new TreeNode(tmp);
        int i=iS;
        for(;i<=iE;i++)
            if(inorder[i]==tmp)
                break;
        node.left=dfs( preorder,  inorder,pS+1,i,iS,i-1);
        node.right=dfs( preorder,  inorder,i+1,pE,i+1,iE);
        return node;
    }

}
