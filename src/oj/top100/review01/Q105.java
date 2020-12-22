package oj.top100.review01;

import oj.dto.TreeNode;

public class Q105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        if (preorder.length == 1) return new TreeNode(preorder[0]);
        TreeNode root = new TreeNode(preorder[0]);
        int i = 0;
        for (; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) break;
        }
        root.left = dfs(preorder, inorder, 1, i, 0, i - 1);
        root.right = dfs(preorder, inorder, i + 1, preorder.length - 1, i + 1, inorder.length - 1);
        return root;
    }

    TreeNode dfs(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        if (ps > pe) return null;
        if (ps == pe) return new TreeNode(preorder[ps]);
        TreeNode root = new TreeNode(preorder[ps]);
        int i = is;
        for (; i <= ie; i++) {
            if (preorder[ps] == inorder[i]) break;
        }
        root.left = dfs(preorder, inorder, ps + 1, ps + i - is, is, i - 1);
        root.right = dfs(preorder, inorder, ps + i - is + 1, pe, i + 1, ie);
        return root;
    }
}
