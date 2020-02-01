package oj.newcoder;

import oj.dto.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    TreeNode dfs(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe)
            return null;
        TreeNode root = new TreeNode(preorder[ps]);
        if (ps == pe)
            return root;
        int nis = is;
        for (; nis < ie; nis++) {
            if (inorder[nis] == preorder[ps])
                break;
        }
        root.left = dfs(preorder, ps + 1, ps + nis - is , inorder, is, nis - 1);
        root.right = dfs(preorder, ps + nis - is + 1, pe, inorder, nis + 1, ie);
        return root;
    }
}
