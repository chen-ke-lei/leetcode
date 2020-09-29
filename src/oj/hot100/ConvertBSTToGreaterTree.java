package oj.hot100;

import oj.dto.TreeNode;

public class ConvertBSTToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return root;
        dfs(root, 0);
        return root;
    }

    int dfs(TreeNode root, int base) {
     //  System.out.println(root.val);
        int right = root.right == null ? 0 : dfs(root.right, base);
        root.val += right;
        root.val += base;
//        System.out.println(root.val);
        int left = root.left == null ? 0 : dfs(root.left, root.val);
        return  left;
    }

    public static void main(String[] args) {
        TreeNode node=TreeNode.creatTreeByString("[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]");
       TreeNode root= new ConvertBSTToGreaterTree().convertBST(node);
       System.out.println(root);
    }
}
