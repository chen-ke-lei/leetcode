package oj.swordtooffer.needthinking;

import oj.dto.TreeNode;

public class Problem54 {
    int res = 0;

    public int kthLargest(TreeNode root, int k) {
        findNode(root, k);
        return res;
    }

    int findNode(TreeNode node, int k) {
        if (node == null)
            return 0;
        int right = findNode(node.right, k);
        if (right == -1) return -1;

        if (right + 1 == k) {
            res = node.val;
            return -1;
        }
        k = k - right - 1;
        int left = findNode(node.left, k);
        if (left == -1) return -1;
        return left + right + 1;
    }
}
