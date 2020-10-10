package oj.hot100;

import oj.dto.TreeNode;


public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        return dfs(preorder,inorder,0,preorder.length-1,0,preorder.length-1);
    }
    TreeNode dfs(int[] preorder, int[] inorder,int pS,int pE,int iS,int iE){
        System.out.println(pS+"  "+pE+"   "+iS+"   "+iE);
        if(pS==pE)
            return new TreeNode(preorder[pS]);
        int tmp=preorder[pS];
        TreeNode node=new TreeNode(tmp);
        int i=iS;
        for(;i<=iE;i++)
            if(inorder[i]==tmp)
                break;
        if(i-1>=iS)
            node.left=dfs( preorder,  inorder,pS+1,i,iS,i-1);
        if(i+1<=iE)
            node.right=dfs( preorder,  inorder,i+1,pE,i+1,iE);
        return node;
    }

    public static void main(String[] args) {
        System.out.println(new ConstructBinaryTreefromPreorderandInorderTraversal()
                .buildTree(new int[]{1,2,3},new int[]{3,2,1}));
    }
}
