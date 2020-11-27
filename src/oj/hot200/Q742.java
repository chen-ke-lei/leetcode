package oj.hot200;

import oj.dto.TreeNode;

public class Q742 {
    int node, length = Integer.MAX_VALUE;

    public int findClosestLeaf(TreeNode root, int k) {
        dfs(false, root, k, 0);
        return node;
    }

    void dfs(boolean find, TreeNode root, int k, int len) {
        if (root.val == k) {
            find = true;
            len = 0;
        }

        if (root.left == null && root.right == null) {
            if (find) {
                if (length > len) {
                    length = len;
                    node = root.val;
                }
            }
        }
        if (root.left != null) {
            dfs(find, root.left, k, len + 1);
        }
        if (root.right != null) {
            dfs(find, root.right, k, len + 1);
        }
    }
}
