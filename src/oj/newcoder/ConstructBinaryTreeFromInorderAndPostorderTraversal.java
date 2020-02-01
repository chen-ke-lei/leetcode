package oj.newcoder;

import oj.dto.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return dfs(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    TreeNode dfs(int[] postorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe)
            return null;
        TreeNode root = new TreeNode(postorder[pe]);
        if (ps == pe)
            return root;
        int nis = is;
        for (; nis < ie; nis++) {
            if (inorder[nis] == postorder[pe])
                break;
        }
        root.left = dfs(postorder, ps, ps + nis - is-1, inorder, is, nis - 1);
        root.right = dfs(postorder, ps + nis - is , pe-1, inorder, nis + 1, ie);
        return root;
    }
}
