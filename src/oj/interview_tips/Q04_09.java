package oj.interview_tips;

import oj.dto.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q04_09 {
    public List<List<Integer>> BSTSequences(TreeNode root) {
        Set<List<Integer>> res = new HashSet<>();
        int length = findLenth(root);
        if (length == 0) {
            res.add(new ArrayList<>());
            return new ArrayList<>(res);
        }
        dfs(root, res, new ArrayList<>(), length);
        return new ArrayList<>(res);
    }

    int findLenth(TreeNode treeNode) {
        if (treeNode == null) return 0;
        return findLenth(treeNode.right) + findLenth(treeNode.left) + 1;
    }

    int dfs(TreeNode node, Set<List<Integer>> res, List<Integer> tmp, int length) {
        if (node == null) return 0;
        tmp.add(node.val);
        int left = dfs(node.left, res, tmp, length);
        int right = dfs(node.right, res, tmp, length);
        if (tmp.size() == length) {
            res.add(new ArrayList<>(tmp));
            for (int i = 0; i < left + right; i++)
                tmp.remove(tmp.size() - 1);
        }

        if (node.left != null && node.right != null) {
            left = dfs(node.left, res, tmp, length);
            right = dfs(node.right, res, tmp, length);
            if (tmp.size() == length) {
                res.add(new ArrayList<>(tmp));
                for (int i = 0; i < left + right; i++)
                    tmp.remove(tmp.size() - 1);
            }
        }

        return tmp.size();
    }
}
