package oj.top100;

import oj.dto.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertBSTToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return root;
        List<Integer> tmp = new ArrayList<>();
        dfs(root, tmp);
        return root;
    }

    void dfs(TreeNode root, List<Integer> tmp) {
        if (root.right != null) dfs(root.right, tmp);
        if (tmp.isEmpty()) tmp.add(0);
        root.val += tmp.get(0);
        tmp.set(0, root.val);
        if (root.left != null) dfs(root.left, tmp);
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.creatTreeByString("[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]");
        TreeNode root = new ConvertBSTToGreaterTree().convertBST(node);
        System.out.println(root);
    }
}
