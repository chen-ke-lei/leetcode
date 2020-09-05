package oj.swordtooffer.needthinking;

import oj.dto.TreeNode;

public class Problem07 {
    public static void main(String[] av){
        new Problem07().buildTree(new int[]{1,2,3},new int[]{3,2,1});
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode node = new TreeNode(preorder[0]);
        int i = 0;
        for (; i < inorder.length; i++) {
            if (inorder[i] == preorder[0])
                break;
        }
        node.left = bt(preorder, inorder, 1, i, 0, i - 1);
        node.right = bt(preorder, inorder, i + 1, preorder.length - 1, i + 1, inorder.length - 1);
        return node;
    }

    TreeNode bt(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        if (ps > pe)
            return null;
        TreeNode node = new TreeNode(preorder[ps]);
        if (ps == pe)
            return node;
        int i = is;
        for (; i <= ie; i++) {
            if (inorder[i] == preorder[ps])
                break;
        }

        node.left = bt(preorder, inorder, ps + 1, i, is, i - 1);
        node.right = bt(preorder, inorder, i + 1, pe, i + 1, ie);
        return node;
    }
}
