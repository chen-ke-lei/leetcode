package oj;

import oj.dto.TreeNode;

public class GivenAbinaryTreeWithTheFollowingRules {
    public static void main(String[] agv) {
        TreeNode node = new TreeNode(-1);
        node.left = new TreeNode(-1);
        node.right = new TreeNode(-1);
        node.left.left = new TreeNode(-1);
        node.left.right = new TreeNode(-1);
        FindElements findElements = new FindElements(node);
        findElements.find(5);
    }
}

class FindElements {
    TreeNode node;

    public FindElements(TreeNode root) {
        node = root;
        if (root != null) {
            root.val = 0;
            init(root);
        }
    }

    void init(TreeNode node) {
        if (node.left != null) {
            node.left.val = node.val * 2 + 1;
            init(node.left);
        }
        if (node.right != null) {
            node.right.val = node.val * 2 + 2;
            init(node.right);
        }
    }

    public boolean find(int target) {
        if (node == null || target < 0)
            return false;
        String t = "";
        TreeNode temp = node;
        while (target > 0) {
            if (target % 2 == 0) {
                target = (target - 2) / 2;
                t = "r" + t;
            } else {
                target = target / 2;
                t = "l" + t;
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == 'r' && temp.right != null)
                temp = temp.right;
            else if (t.charAt(i) == 'l' && temp.left != null)
                temp = temp.left;
            else
                return false;
        }
        return true;
    }
}