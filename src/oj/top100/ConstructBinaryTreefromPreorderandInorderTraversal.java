package oj.top100;

import oj.dto.TreeNode;


public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);
    }

    TreeNode dfs(int[] preorder, int[] inorder, int pS, int pE, int iS, int iE) {
        //  System.out.println(pS+"  "+pE+"   "+iS+"   "+iE);
        if (pE < pS || iE < iS) return null;
        if (pS == pE)
            return new TreeNode(preorder[pS]);
        int tmp = preorder[pS];
        TreeNode node = new TreeNode(tmp);
        int i = 0;
        for (; i <= iE - iS; i++)
            if (inorder[i + iS] == tmp)
                break;
        node.left = dfs(preorder, inorder, pS + 1, pS + i, iS, i + iS - 1);
        node.right = dfs(preorder, inorder, pS + i + 1, pE, iS + i + 1, iE);
        return node;
    }

    public static void main(String[] args) {
        System.out.println(new ConstructBinaryTreefromPreorderandInorderTraversal()
                .buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1}));
    }
}
