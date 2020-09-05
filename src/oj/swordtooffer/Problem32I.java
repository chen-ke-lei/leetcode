package oj.swordtooffer;

import oj.dto.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Problem32I {
    public int[] levelOrder(TreeNode root) {
        ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
        List<Integer> a = new ArrayList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            a.add(node.val);
            if (node.left != null)
                nodes.offer(node.left);
            if (node.right != null)
                nodes.offer(node.right);
        }
        int[] res = new int[a.size()];
        for (int i = 0; i < a.size(); i++) res[i] = a.get(i);
        return res;
    }
}
