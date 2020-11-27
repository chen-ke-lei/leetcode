package oj.interview_tips;

import oj.dto.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q04_12 {
    int num = 0;

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        dfs(root, sum, map, 0);
        return num;
    }

    void dfs(TreeNode node, int sum, Map<Integer, Integer> map, int tmp) {
        if (node == null) return;
        tmp += node.val;
        map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        if (sum != 0 || node.val != tmp)
            num += map.getOrDefault(tmp - sum, 0);
        dfs(node.left, sum, map, tmp);
        dfs(node.right, sum, map, tmp);
        map.put(tmp, map.getOrDefault(tmp, 1) - 1);
    }
}
