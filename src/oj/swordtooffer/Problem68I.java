package oj.swordtooffer;

import oj.dto.TreeNode;

import java.util.ArrayList;

public class Problem68I {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pList = new ArrayList<>(), qList = new ArrayList<>();
        dfs(root, p, pList);
        dfs(root, q, qList);
        int i = 0;
        while (pList.size() > i && qList.size() > i) {
            if (pList.get(i) != qList.get(i))
                break;
            i++;
        }
        return i > 0 ? pList.get(i - 1) : root;
    }

    boolean dfs(TreeNode root, TreeNode node, ArrayList<TreeNode> nodes) {
        if (root == null)return false;
        nodes.add(root);
        if (root == node) return true;
        if (dfs(root.left, node, nodes)) return true;
        if (dfs(root.right, node, nodes)) return true;
        nodes.remove(nodes.size() - 1);
        return false;
    }
}
