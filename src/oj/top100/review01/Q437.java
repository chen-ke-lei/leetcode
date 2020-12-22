package oj.top100.review01;

import oj.dto.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q437 {
    int max = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        dfs(root, 0, sum, map);
        return max;
    }

    void dfs(TreeNode root, int tmp, int target, Map<Integer, Integer> map) {
        if (root == null) return;
        tmp += root.val;
        map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        max += map.getOrDefault(tmp - target, 0);
        if (target == 0) max--;
        if (root.left != null) dfs(root.left, tmp, target, map);
        if (root.right != null) dfs(root.right, tmp, target, map);
        map.put(tmp, map.get(tmp) - 1);
    }
}
