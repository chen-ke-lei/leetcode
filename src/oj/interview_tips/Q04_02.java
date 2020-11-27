package oj.interview_tips;

import oj.dto.TreeNode;

public class Q04_02 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        int tmp = (0 + nums.length - 1) / 2;
        TreeNode res = new TreeNode(nums[tmp]);
        res.left = dfs(nums, 0, tmp - 1);
        res.right = dfs(nums, tmp + 1, nums.length - 1);
        return res;
    }

    TreeNode dfs(int[] nums, int start, int end) {
        if (start > end) return null;
        int tmp = (start + end) / 2;
        TreeNode node = new TreeNode(nums[tmp]);
        node.left = dfs(nums, start, tmp - 1);
        node.right = dfs(nums, tmp + 1, end);
        return node;
    }
}
