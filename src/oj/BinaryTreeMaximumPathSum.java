package oj;

import oj.dto.TreeNode;

public class BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {
		int left = Integer.MIN_VALUE;
		int right = Integer.MIN_VALUE;
		int maxTmp = 0;
		if (root == null)
			return 0;
		int tmpVal = root.val;
		if (root.left != null) {
			left = maxPathSum(root.left);
			tmpVal += root.left.val;
			maxTmp = Math.max(maxTmp, root.left.val);
		}
		if (root.right != null) {
			right = maxPathSum(root.right);
			tmpVal += root.right.val;
			maxTmp = Math.max(maxTmp, root.right.val);
		}
		root.val = Math.max(0, root.val + maxTmp);
		return Math.max(Math.max(left, right), tmpVal);
	}
}
