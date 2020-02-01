package oj.newcoder;

import oj.dto.TreeNode;

import java.util.ArrayList;

public class pathSumII {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        dfs(root,sum,new ArrayList<>(),res);
        return res;
    }

    void dfs(TreeNode root, int sum, ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> res) {
        if (root == null)
            return;
        tmp.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new ArrayList<>(tmp));

        } else {
            dfs(root.left, sum - root.val, tmp, res);
            dfs(root.right, sum - root.val, tmp, res);
        }
        tmp.remove(tmp.size() - 1);
    }
}
