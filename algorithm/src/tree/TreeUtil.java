package src.tree;

import oj.dto.TreeNode;

public class TreeUtil {
    public static TreeNode createApproachBalanceTree(int num) {
        return creatTree(0, num);
    }

    static TreeNode creatTree(int left, int right) {
        if (left >= right)
            return new TreeNode(left);
        int val = (left + right) / 2;
        TreeNode node = new TreeNode(val);
        if (left != val)
            node.left = creatTree(left, val - 1);
        if (right != val)
            node.right = creatTree(val + 1, right);
        return node;
    }

    public static void mindleDfs(TreeNode node) {
        if (node == null)
            return;
        mindleDfs(node.left);
        System.out.print(node.val + "  ");
        mindleDfs(node.right);
    }
}
