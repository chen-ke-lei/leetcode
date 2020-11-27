package oj.hot200;

import oj.dto.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Q272 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x1, x2) -> {
            double x1Tmp = Math.abs(x1 - target);
            double x2Tmp = Math.abs(x2 - target);
            if (x1Tmp == x2Tmp) return 0;
            if (x1Tmp > x2Tmp) return -1;
            return 1;
        });
        List<Integer> res = new LinkedList<>();
        dfs(root, queue, k);
        while (!queue.isEmpty()) res.add(0, queue.poll());
        return res;
    }

    void dfs(TreeNode node, PriorityQueue<Integer> queue, int k) {
        if (node.left != null)
            dfs(node.left, queue, k);
        queue.offer(node.val);
        if (queue.size() > k) queue.poll();
        if (node.right != null) dfs(node.right, queue, k);
    }
}
